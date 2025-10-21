package com.seif.firstcomposeapp.data

class Constants {
    companion object {
        const val BASE_URL = " https://api.github.com/"
        const val GITHUB_REPOS_ENDPOINT = "search/repositories?q=language"
    }
}

// ui -> domain -> data
// multi modules

// DDD ( Domain Driven Design)
// ui -> domain <- data