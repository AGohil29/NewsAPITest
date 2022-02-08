package com.arun.newsapiclient.domain.usecase

import com.arun.newsapiclient.data.model.Article
import com.arun.newsapiclient.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}