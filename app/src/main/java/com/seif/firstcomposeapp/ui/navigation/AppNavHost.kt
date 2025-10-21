package com.seif.firstcomposeapp.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seif.firstcomposeapp.ui.screens.repo_details.RepoDetailsScreen
import com.seif.firstcomposeapp.ui.screens.repo_list.RepoListScreen

@Composable
fun AppNavHost(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.RepoListScreen.route
    ) {
        composable(route =  Screens.RepoListScreen.route){
            RepoListScreen(
                innerPadding
            ){ owner, name ->
                navController.navigate(Screens.RepoDetailsScreen.route)
            }
        }
        composable(route = Screens.RepoDetailsScreen.route){
            RepoDetailsScreen(innerPadding)
        }
    }
}