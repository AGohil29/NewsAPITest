package com.arun.newsapiclient.data.api

import com.arun.newsapiclient.BuildConfig
import com.arun.newsapiclient.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {
  @GET("v2/top-headlines")
  suspend fun getTopHeadlines(
      @Query("country")
      country:String,
      @Query("apiKey")
      apiKey:String = "2352d41b50804fcebefbbe2fde7d8b13"
  ): Response<APIResponse>

}