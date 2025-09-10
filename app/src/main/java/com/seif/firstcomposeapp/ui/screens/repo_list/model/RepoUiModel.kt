package com.seif.firstcomposeapp.ui.screens.repo_list.model

data class RepoUiModel(
    val id: Int,
    val name: String,
    val avatar:String,
    val description: String,
    val stars: Int,
    val owner:String
)
