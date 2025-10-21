package com.seif.firstcomposeapp.data.repository

import com.seif.firstcomposeapp.data.data_source.remote.RemoteDataSource
import com.seif.firstcomposeapp.data.mapper.toGithubReposDomainModel
import com.seif.firstcomposeapp.domain.model.GithubReposDomainModel
import com.seif.firstcomposeapp.domain.repository.GithubReposRepository

class GithubReposRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): GithubReposRepository {
    override fun fetchGithubRepos(): List<GithubReposDomainModel> {
        return remoteDataSource.fetchGithubRepos().toGithubReposDomainModel()
    }
}