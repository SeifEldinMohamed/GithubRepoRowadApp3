package com.seif.firstcomposeapp.data.data_source.remote.retrofit.api

import com.seif.firstcomposeapp.data.Constants.Companion.GITHUB_REPO_DETAILS_ENDPOINT
import com.seif.firstcomposeapp.data.Constants.Companion.OWNER_NAME_KEY
import com.seif.firstcomposeapp.data.Constants.Companion.REPO_NAME_KEY
import com.seif.firstcomposeapp.data.data_source.remote.retrofit.model.details.RepoDetailsDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoDetailsApi {
    @GET(GITHUB_REPO_DETAILS_ENDPOINT)
    suspend fun fetchRepoDetails(
       @Path(OWNER_NAME_KEY) ownerName:String,
       @Path(REPO_NAME_KEY) repoName: String
    ): Response<RepoDetailsDataModel>
}
