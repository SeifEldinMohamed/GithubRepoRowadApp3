package com.seif.firstcomposeapp.data.mapper

import com.seif.firstcomposeapp.data.data_source.local.room.entities.RepoEntity
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

fun List<RepoEntity>.toGithubReposDomainModel(): List<GithubReposDomainModel> {
    return this.map { repoEntity ->
        GithubReposDomainModel(
            id = repoEntity.id,
            name = repoEntity.name,
            avatar = repoEntity.avatar,
            description = repoEntity.description,
            stars = repoEntity.starsCount,
            owner = repoEntity.ownerName
        )
    }
}