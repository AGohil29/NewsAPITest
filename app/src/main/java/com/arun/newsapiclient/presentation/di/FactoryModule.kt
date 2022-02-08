package com.arun.newsapiclient.presentation.di

import android.app.Application
import com.arun.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.arun.newsapiclient.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class FactoryModule {
    @Singleton
    @Provides
  fun provideNewsViewModelFactory(
     application: Application,
     getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
  ):NewsViewModelFactory{
      return NewsViewModelFactory(
          application,
          getNewsHeadlinesUseCase
      )
  }
}








