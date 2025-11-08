package com.seif.firstcomposeapp.data.mapper

import com.seif.firstcomposeapp.data.data_source.local.room.entities.RepoEntity
import com.seif.firstcomposeapp.data.data_source.remote.retrofit.model.Repo

fun List<Repo>.toGithubRepoEntity(): List<RepoEntity> {
    return this.map { repo ->
        RepoEntity(
            id = repo.id,
            name = repo.name,
            avatar = repo.owner.avatar_url,
            ownerName = repo.owner.login,
            description = repo.description,
            starsCount = repo.stargazers_count
        )
    }
}