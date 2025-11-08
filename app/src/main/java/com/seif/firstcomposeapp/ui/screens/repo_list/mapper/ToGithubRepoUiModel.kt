package com.seif.firstcomposeapp.ui.screens.repo_list.mapper

import com.seif.firstcomposeapp.domain.model.GithubReposDomainModel
import com.seif.firstcomposeapp.ui.screens.repo_list.model.GithubReposUiModel

fun List<GithubReposDomainModel>.toGithubRepoListUiModel(): List<GithubReposUiModel> {
    return this.map { githubReposDomainModel ->
        GithubReposUiModel(
            id = githubReposDomainModel.id,
            name = githubReposDomainModel.name,
            avatar = githubReposDomainModel.avatar,
            description = githubReposDomainModel.description,
            stars = githubReposDomainModel.stars,
            owner = githubReposDomainModel.owner
        )
    }
}