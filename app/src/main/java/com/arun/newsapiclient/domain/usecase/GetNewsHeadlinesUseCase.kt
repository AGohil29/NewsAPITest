package com.arun.newsapiclient.domain.usecase

import com.arun.newsapiclient.data.model.APIResponse
import com.arun.newsapiclient.data.util.Resource
import com.arun.newsapiclient.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country : String, page : Int): Resource<APIResponse>{
        return newsRepository.getNewsHeadlines(country,page)
    }
}