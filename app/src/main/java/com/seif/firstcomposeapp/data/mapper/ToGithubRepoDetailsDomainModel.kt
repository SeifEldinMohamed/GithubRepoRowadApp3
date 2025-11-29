package com.seif.firstcomposeapp.data.mapper

import com.seif.firstcomposeapp.data.data_source.remote.retrofit.model.details.RepoDetailsDataModel
import com.seif.firstcomposeapp.domain.model.RepoDetailsDomainModel

fun RepoDetailsDataModel.toRepoDetailsDomainModel(): RepoDetailsDomainModel {
    return RepoDetailsDomainModel(
        id = this.id,
        name = this.name,
        avatar = this.owner.avatar_url,
        description = this.description,
        forksCount = this.forks_count,
        starsCount = this.stargazers_count,
        language = this.language.orEmpty(),
        ownerName = this.owner.login,
        createdAt = this.created_at
    )
}
