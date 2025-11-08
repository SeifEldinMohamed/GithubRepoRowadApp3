package com.seif.firstcomposeapp.domain.repository

import com.seif.firstcomposeapp.domain.model.GithubReposDomainModel

interface GithubReposRepository {
    suspend fun fetchGithubRepos(): List<GithubReposDomainModel>
}