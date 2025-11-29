package com.seif.firstcomposeapp.data.repository

import com.seif.firstcomposeapp.data.data_source.local.LocalDataSource
import com.seif.firstcomposeapp.data.data_source.remote.RemoteDataSource
import com.seif.firstcomposeapp.data.mapper.toGithubRepoEntity
import com.seif.firstcomposeapp.data.mapper.toGithubReposDomainModel
import com.seif.firstcomposeapp.data.mapper.toRepoDetailsDomainModel
import com.seif.firstcomposeapp.domain.model.GithubReposDomainModel
import com.seif.firstcomposeapp.domain.model.RepoDetailsDomainModel
import com.seif.firstcomposeapp.domain.repository.GithubReposRepository
import javax.inject.Inject

class GithubReposRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): GithubReposRepository {
    override suspend fun fetchGithubRepos(): List<GithubReposDomainModel> {
        if (localDataSource.readIsFirstTimeEnterApp()){
            val githubReposDataModel = remoteDataSource.fetchGithubRepos()
            localDataSource.insertRepoList(githubReposDataModel.repos.toGithubRepoEntity())
            val cachedRepoDomainModelList = localDataSource.getRepoList().toGithubReposDomainModel()
            localDataSource.saveFirstTimeEnterApp(isFirstTime = false)
            return cachedRepoDomainModelList
        } else {
            return localDataSource.getRepoList().toGithubReposDomainModel()
        }
    }

    override suspend fun fetchGithubRepoDetails(
        ownerName: String,
        repoName: String,
    ): RepoDetailsDomainModel {
        return remoteDataSource.fetchGithubRepoDetails(ownerName, repoName).toRepoDetailsDomainModel()
    }
}

// get list from database
// list is empty -> call api -> save in database -> get list from database then map to domain model to retrun it
// list is not empty then return list

// datastore to save first time user login
// isFirstTime = true -> call api -> save in database -> get list from database then map to domain model to retrun it ( before return make isFirstTime = false )
// isFirstTime = false -> get list from database then return it