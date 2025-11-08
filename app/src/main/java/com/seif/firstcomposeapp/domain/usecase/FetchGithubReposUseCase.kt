package com.seif.firstcomposeapp.domain.usecase

import com.seif.firstcomposeapp.domain.model.GithubReposDomainModel
import com.seif.firstcomposeapp.domain.repository.GithubReposRepository
import javax.inject.Inject

class FetchGithubReposUseCase @Inject constructor(
    private val githubReposRepository: GithubReposRepository
) {
   suspend operator fun invoke(): List<GithubReposDomainModel> {
        return githubReposRepository.fetchGithubRepos()
    }
}