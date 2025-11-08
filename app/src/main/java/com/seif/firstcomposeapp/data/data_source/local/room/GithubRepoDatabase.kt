package com.seif.firstcomposeapp.data.data_source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seif.firstcomposeapp.data.data_source.local.room.entities.RepoEntity

@Database(
    entities = [RepoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GithubRepoDatabase: RoomDatabase() {
    abstract fun repoDao(): RepoDao
}