package com.seif.firstcomposeapp.domain.usecase

import com.seif.firstcomposeapp.domain.model.GithubReposDomainModel
import com.seif.firstcomposeapp.domain.repository.GithubReposRepository

class FetchGithubReposUseCase(
    private val githubReposRepository: GithubReposRepository
) {
   operator fun invoke(): List<GithubReposDomainModel> {
        return githubReposRepository.fetchGithubRepos()
    }
}