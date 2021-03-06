package com.arun.newsapiclient.data.repository

import com.arun.newsapiclient.data.model.APIResponse
import com.arun.newsapiclient.data.model.Article
import com.arun.newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import com.arun.newsapiclient.data.util.Resource
import com.arun.newsapiclient.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
        private val newsRemoteDataSource: NewsRemoteDataSource
):NewsRepository {
    override suspend fun getNewsHeadlines(country: String): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country))
    }

    private fun responseToResource(response:Response<APIResponse>):Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}