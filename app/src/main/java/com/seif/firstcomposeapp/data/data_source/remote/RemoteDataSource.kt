package com.seif.firstcomposeapp.data.data_source.remote

import com.seif.firstcomposeapp.data.data_source.remote.retrofit.api.GithubApi
import com.seif.firstcomposeapp.data.data_source.remote.retrofit.api.RepoDetailsApi
import com.seif.firstcomposeapp.data.data_source.remote.retrofit.model.GithubReposDataModel
import com.seif.firstcomposeapp.data.data_source.remote.retrofit.model.details.RepoDetailsDataModel
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val githubApi: GithubApi,
    private val repoDetailsApi: RepoDetailsApi
) {
    suspend fun fetchGithubRepos(): GithubReposDataModel {
        return try {
            githubApi.fetchGithubRepos().body() as GithubReposDataModel
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun fetchGithubRepoDetails(
        ownerName: String,
        repoName: String
    ): RepoDetailsDataModel {
        return try {
            repoDetailsApi.fetchRepoDetails(
                ownerName,
                repoName
            ).body() as RepoDetailsDataModel
        } catch (e: Exception) {
            throw e
        }
    }
}