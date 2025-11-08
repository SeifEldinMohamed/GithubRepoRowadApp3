package com.seif.firstcomposeapp.data

class Constants {
    companion object {
        const val BASE_URL = " https://api.github.com/"
        const val GITHUB_REPOS_ENDPOINT = "search/repositories?q=language"
        const val DATABASE_NAME = "github_repo_database"
        const val PREFERENCES_NAME = "preference_name"
        const val PREFERENCES_IS_FIRST_TIME_KEY = "is_first_time_key"
    }
}

// ui -> domain -> data
// multi modules

// DDD ( Domain Driven Design)
// ui -> domain <- data