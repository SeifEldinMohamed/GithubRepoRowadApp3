package com.seif.firstcomposeapp.domain.model

data class RepoDetailsDomainModel(
    val id: Int,
    val name: String,
    val avatar: String,
    val description:String,
    val forksCount: Long,
    val starsCount: Long,
    val language: String,
    val ownerName: String,
    val createdAt: String
)
