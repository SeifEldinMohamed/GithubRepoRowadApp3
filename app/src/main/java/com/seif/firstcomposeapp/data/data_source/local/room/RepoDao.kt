package com.seif.firstcomposeapp.data.data_source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seif.firstcomposeapp.data.data_source.local.room.entities.RepoEntity

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepoList(repoList: List<RepoEntity>)

    @Query("SELECT * FROM REPOENTITY")
    suspend fun getRepoList(): List<RepoEntity>
}