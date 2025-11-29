package com.seif.firstcomposeapp.di

import com.seif.firstcomposeapp.ui.utils.DispatcherProvider
import com.seif.firstcomposeapp.ui.utils.StandardDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider {
        return StandardDispatcherProvider()
    }
}
