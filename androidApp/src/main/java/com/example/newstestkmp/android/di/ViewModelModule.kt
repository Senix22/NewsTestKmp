package com.example.newstestkmp.android.di

import com.example.newstestkmp.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ArticlesViewModel(get()) }
}