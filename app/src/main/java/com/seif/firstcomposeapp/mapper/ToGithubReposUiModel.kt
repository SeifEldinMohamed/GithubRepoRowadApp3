package com.seif.firstcomposeapp.mapper

import com.seif.firstcomposeapp.data.data_source.remote.retrofit.model.GithubReposDataModel
import com.seif.firstcomposeapp.ui.screens.repo_list.model.GithubReposUiModel

fun GithubReposDataModel.toGithubReposUiModel(): List<GithubReposUiModel> {
    return this.repos.map { repo ->
        GithubReposUiModel(
            id = repo.id,
            name = repo.name,
            avatar = repo.owner.avatar_url,
            description = repo.description,
            stars = repo.stargazers_count,
            owner = repo.owner.login
        )
    }
}