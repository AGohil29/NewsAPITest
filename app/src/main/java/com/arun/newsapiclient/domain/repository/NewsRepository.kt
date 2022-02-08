package com.arun.newsapiclient.domain.repository

import com.arun.newsapiclient.data.model.APIResponse
import com.arun.newsapiclient.data.model.Article
import com.arun.newsapiclient.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository{
      suspend fun getNewsHeadlines(country : String): Resource<APIResponse>
}