package com.seif.firstcomposeapp.di

import android.content.Context
import androidx.room.Room
import com.seif.firstcomposeapp.data.Constants.Companion.DATABASE_NAME
import com.seif.firstcomposeapp.data.data_source.local.datastore.PreferenceDataStore
import com.seif.firstcomposeapp.data.data_source.local.room.GithubRepoDatabase
import com.seif.firstcomposeapp.data.data_source.local.room.RepoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideRoomInstance(
      @ApplicationContext  context: Context
    ): GithubRepoDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = GithubRepoDatabase::class.java,
            name = DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepoDao(
        githubRepoDatabase: GithubRepoDatabase
    ): RepoDao {
        return githubRepoDatabase.repoDao()
    }

    @Provides
    @Singleton
    fun providePreferenceDataStore(
        @ApplicationContext context: Context
    ): PreferenceDataStore {
        return PreferenceDataStore(context)
    }
}