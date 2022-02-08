package com.arun.newsapiclient.domain.usecase

import com.arun.newsapiclient.data.model.APIResponse
import com.arun.newsapiclient.data.util.Resource
import com.arun.newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
     suspend fun execute(searchQuery:String): Resource<APIResponse>{
         return newsRepository.getSearchedNews(searchQuery)
     }
}