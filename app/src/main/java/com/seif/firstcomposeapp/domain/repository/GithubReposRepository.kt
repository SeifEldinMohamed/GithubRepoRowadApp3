package com.seif.firstcomposeapp.domain.repository

import com.seif.firstcomposeapp.domain.model.GithubReposDomainModel
import com.seif.firstcomposeapp.domain.model.RepoDetailsDomainModel

interface GithubReposRepository {
    suspend fun fetchGithubRepos(): List<GithubReposDomainModel>
    suspend fun fetchGithubRepoDetails(
        ownerName:String,
        repoName:String
    ): RepoDetailsDomainModel
}