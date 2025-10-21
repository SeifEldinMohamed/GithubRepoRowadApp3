package com.seif.firstcomposeapp

import com.seif.firstcomposeapp.data.Constants.Companion.BASE_URL
import com.seif.firstcomposeapp.data.data_source.remote.retrofit.api.GithubApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideGithubApi(): GithubApi {
    return provideRetrofit()
        .create(GithubApi::class.java)
}
