package com.seif.firstcomposeapp.domain.model

data class  GithubReposDomainModel(
    val id: Int,
    val name:String,
    val avatar: String,
    val description: String,
    val owner: String,
    val stars: Int
)
