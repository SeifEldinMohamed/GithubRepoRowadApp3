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
        startDestination = "repo_list_screen"
    ) {
        composable(route = "repo_list_screen"){
            RepoListScreen(
                innerPadding
            ){ owner, name ->
                navController.navigate("repo_details_screen")
            }
        }
        composable(route = "repo_details_screen"){
            RepoDetailsScreen(innerPadding)
        }
    }
}