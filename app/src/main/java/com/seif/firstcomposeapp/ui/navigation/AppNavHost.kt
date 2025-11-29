package com.seif.firstcomposeapp.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seif.firstcomposeapp.ui.Constants.Companion.OWNER_NAME_KEY
import com.seif.firstcomposeapp.ui.Constants.Companion.REPO_NAME_KEY
import com.seif.firstcomposeapp.ui.screens.repo_details.RepoDetailsScreen
import com.seif.firstcomposeapp.ui.screens.repo_list.RepoListScreen

@Composable
fun AppNavHost(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.RepoListScreen.route
    ) {
        composable(route = Screens.RepoListScreen.route) {
            RepoListScreen(
                innerPadding
            ) { owner, name ->
                navController.navigate(Screens.RepoDetailsScreen.passOwnerAndName(owner, name))
            }
        }
        composable(route = Screens.RepoDetailsScreen.route) { navBackStackEntry ->
            val ownerName = navBackStackEntry.arguments?.getString(OWNER_NAME_KEY)
            val repoName = navBackStackEntry.arguments?.getString(REPO_NAME_KEY)
            if (ownerName!=null && repoName != null){
                RepoDetailsScreen(innerPadding, ownerName, repoName)
            }
        }
    }
}