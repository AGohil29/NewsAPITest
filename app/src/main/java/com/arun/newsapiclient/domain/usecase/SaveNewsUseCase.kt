package com.arun.newsapiclient.domain.usecase

import com.arun.newsapiclient.data.model.Article
import com.arun.newsapiclient.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
  suspend fun execute(article: Article)=newsRepository.saveNews(article)
}