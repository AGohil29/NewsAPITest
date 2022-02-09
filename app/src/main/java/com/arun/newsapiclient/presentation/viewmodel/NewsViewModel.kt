package com.arun.newsapiclient.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arun.newsapiclient.data.model.APIResponse
import com.arun.newsapiclient.data.util.Resource
import com.arun.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
) : ViewModel() {
    val newsHeadLines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadLines(country: String) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadLines.postValue(Resource.Loading())
        try {
            val apiResult = getNewsHeadlinesUseCase.execute(country)
            newsHeadLines.postValue(apiResult)
        } catch (e: Exception) {
            newsHeadLines.postValue(Resource.Error(e.message.toString()))
        }
    }
}














