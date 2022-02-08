package com.arun.newsapiclient.data.repository.dataSourceImpl

import com.arun.newsapiclient.data.api.NewsAPIService
import com.arun.newsapiclient.data.model.APIResponse
import com.arun.newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
        private val newsAPIService: NewsAPIService
):NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country : String, page : Int): Response<APIResponse> {
          return newsAPIService.getTopHeadlines(country,page)
    }
}