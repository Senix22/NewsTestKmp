package com.example.newstestkmp.di

import ArticlesRepository
import com.example.newstestkmp.ArticleDataSource
import com.example.newstestkmp.ArticlesViewModel
import com.example.newstestkmp.data.api.ArticleService
import com.example.newstestkmp.data.api.ArticleUseCase
import com.example.newstestkmp.data.api.ArticlesResponse
import org.koin.dsl.module


val articlesModule = module {
    single<ArticleService> {
        ArticleService(get())
    }
    single<ArticleUseCase> {
        ArticleUseCase(get())
    }
    single<ArticlesViewModel> {
        ArticlesViewModel(get())
    }
    single<ArticleDataSource> { ArticleDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}