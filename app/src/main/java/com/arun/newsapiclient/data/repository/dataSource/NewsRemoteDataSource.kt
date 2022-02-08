package com.arun.newsapiclient.data.repository.dataSource

import com.arun.newsapiclient.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country : String, page : Int):Response<APIResponse>
}