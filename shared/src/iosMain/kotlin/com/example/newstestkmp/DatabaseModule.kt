package com.example.newstestkmp

import app.cash.sqldelight.db.SqlDriver
import com.example.newstestkmp.db.DatabaseFactory
import com.example.newstestkmp.db.NewsTestDatabase
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseFactory().create() }

    single<NewsTestDatabase> { NewsTestDatabase(get()) }
}