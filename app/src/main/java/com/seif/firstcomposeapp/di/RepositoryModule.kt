package com.seif.firstcomposeapp.di

import com.seif.firstcomposeapp.data.repository.GithubReposRepositoryImpl
import com.seif.firstcomposeapp.domain.repository.GithubReposRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideGithubRepositoryImpl(
        githubReposRepositoryImpl: GithubReposRepositoryImpl
    ): GithubReposRepository
}