package com.seif.firstcomposeapp.data.data_source.remote.retrofit.api

import com.seif.firstcomposeapp.data.Constants.Companion.GITHUB_REPOS_ENDPOINT
import com.seif.firstcomposeapp.data.data_source.remote.retrofit.model.GithubReposDataModel
import retrofit2.Response
import retrofit2.http.GET

interface GithubApi {
    @GET(GITHUB_REPOS_ENDPOINT)
    fun fetchGithubRepos(): Response<GithubReposDataModel>
}
