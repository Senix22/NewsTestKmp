package com.example.newstestkmp.di

import org.koin.dsl.module

val sharedKoinModule = listOf(networkModule, articlesModule)