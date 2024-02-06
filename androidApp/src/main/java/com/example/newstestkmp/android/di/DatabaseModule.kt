package com.example.newstestkmp.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.newstestkmp.db.DatabaseFactory
import com.example.newstestkmp.db.NewsTestDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataBaseModule = module {
    single<SqlDriver> { DatabaseFactory(androidContext()).create()}

    single<NewsTestDatabase>{
        NewsTestDatabase(get())
    }
}