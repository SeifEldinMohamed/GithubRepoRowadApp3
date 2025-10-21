package com.seif.firstcomposeapp.data.data_source.remote.retrofit.model

import com.google.gson.annotations.SerializedName

data class GithubReposDataModel(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val repos: List<Repo>,
    @SerializedName("total_count")
    val totalCount: Int?
)