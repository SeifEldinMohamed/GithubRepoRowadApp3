package com.seif.firstcomposeapp.data.data_source.remote

import com.seif.firstcomposeapp.data.data_source.remote.retrofit.api.GithubApi
import com.seif.firstcomposeapp.data.data_source.remote.retrofit.model.GithubReposDataModel

class RemoteDataSource(
    private val githubApi: GithubApi,
) {
    fun fetchGithubRepos(): GithubReposDataModel {
        return try {
            githubApi.fetchGithubRepos().body() as GithubReposDataModel
        } catch (e: Exception) {
            throw e
        }
    }
}