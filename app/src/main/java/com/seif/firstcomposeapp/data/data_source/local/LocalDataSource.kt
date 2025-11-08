package com.seif.firstcomposeapp.data.data_source.local

import com.seif.firstcomposeapp.data.data_source.local.datastore.PreferenceDataStore
import com.seif.firstcomposeapp.data.data_source.local.room.RepoDao
import com.seif.firstcomposeapp.data.data_source.local.room.entities.RepoEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val repoDao: RepoDao,
    private val preferenceDataStore: PreferenceDataStore
) {
    suspend fun insertRepoList(repoList: List<RepoEntity>){
        repoDao.insertRepoList(repoList)
    }

    suspend fun getRepoList(): List<RepoEntity> {
        return repoDao.getRepoList()
    }

    suspend fun readIsFirstTimeEnterApp(): Boolean {
        return preferenceDataStore.readIsFirstFirstTimeEnterApp()
    }

    suspend fun saveFirstTimeEnterApp(isFirstTime: Boolean) {
        preferenceDataStore.saveIsFirstFirstTimeEnterApp(isFirstTime)
    }
}