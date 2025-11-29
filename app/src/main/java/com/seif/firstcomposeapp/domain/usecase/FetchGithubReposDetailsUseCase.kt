package com.seif.firstcomposeapp.domain.usecase

import com.seif.firstcomposeapp.domain.model.RepoDetailsDomainModel
import com.seif.firstcomposeapp.domain.repository.GithubReposRepository
import javax.inject.Inject

class FetchGithubReposDetailsUseCase @Inject constructor(
    private val githubReposRepository: GithubReposRepository
) {
   suspend operator fun invoke(
       ownerName:String,
       repoName:String
   ): RepoDetailsDomainModel {
        return githubReposRepository.fetchGithubRepoDetails(
            ownerName, repoName
        )
    }
}