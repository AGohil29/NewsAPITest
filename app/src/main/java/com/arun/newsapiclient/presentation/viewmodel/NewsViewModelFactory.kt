package com.arun.newsapiclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arun.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase

class NewsViewModelFactory(
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(
            getNewsHeadlinesUseCase
        ) as T
    }
}









