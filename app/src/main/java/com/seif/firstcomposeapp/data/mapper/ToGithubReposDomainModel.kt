package com.seif.firstcomposeapp.data.mapper

import com.seif.firstcomposeapp.data.data_source.remote.retrofit.model.GithubReposDataModel
import com.seif.firstcomposeapp.domain.model.GithubReposDomainModel

fun GithubReposDataModel.toGithubReposDomainModel(): List<GithubReposDomainModel> {
    return this.repos.map { repo ->
        GithubReposDomainModel(
            id = repo.id,
            name = repo.name,
            avatar = repo.owner.avatar_url,
            description = repo.description,
            stars = repo.stargazers_count,
            owner = repo.owner.login
        )
    }
}