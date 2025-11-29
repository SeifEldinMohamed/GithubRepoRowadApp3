package com.seif.firstcomposeapp.ui.screens.repo_list.mapper

import com.seif.firstcomposeapp.domain.model.RepoDetailsDomainModel
import com.seif.firstcomposeapp.ui.screens.repo_list.model.RepoDetailsUiModel

fun RepoDetailsDomainModel.toRepoDetailsUiModel(): RepoDetailsUiModel {
    return RepoDetailsUiModel(
        id = this.id,
        name = this.name,
        avatar = this.avatar,
        description = this.description,
        forksCount = this.forksCount.toString(),
        starsCount = this.starsCount.toString(),
        language = this.language,
        ownerName = this.ownerName,
        createdAt = this.createdAt
    )
}