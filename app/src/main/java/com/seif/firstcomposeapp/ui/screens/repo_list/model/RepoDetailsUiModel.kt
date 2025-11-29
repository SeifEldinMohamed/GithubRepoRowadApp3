package com.seif.firstcomposeapp.ui.screens.repo_list.model

data class RepoDetailsUiModel(
    val id: Int,
    val name: String,
    val avatar: String,
    val description:String,
    val forksCount: String,
    val starsCount: String,
    val language: String,
    val ownerName: String,
    val createdAt: String
)
