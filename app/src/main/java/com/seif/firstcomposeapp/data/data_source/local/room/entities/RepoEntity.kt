package com.seif.firstcomposeapp.data.data_source.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RepoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val avatar: String,
    val ownerName: String,
    val description: String,
    val starsCount: Int
)
