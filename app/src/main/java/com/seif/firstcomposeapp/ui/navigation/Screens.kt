package com.seif.firstcomposeapp.ui.navigation

import com.seif.firstcomposeapp.ui.Constants.Companion.OWNER_NAME_KEY
import com.seif.firstcomposeapp.ui.Constants.Companion.REPO_DETAILS_SCREEN_ROUTE
import com.seif.firstcomposeapp.ui.Constants.Companion.REPO_LIST_SCREEN_ROUTE
import com.seif.firstcomposeapp.ui.Constants.Companion.REPO_NAME_KEY

sealed class Screens(val route: String) {
    data object RepoListScreen: Screens(REPO_LIST_SCREEN_ROUTE)
    data object RepoDetailsScreen : Screens("$REPO_DETAILS_SCREEN_ROUTE/{$OWNER_NAME_KEY}/{$REPO_NAME_KEY}"){
        fun passOwnerAndName(ownerName: String, repoName:String): String {
            return "$REPO_DETAILS_SCREEN_ROUTE/$ownerName/$repoName"
        }
    }
}