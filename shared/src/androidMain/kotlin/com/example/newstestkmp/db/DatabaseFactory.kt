package com.example.newstestkmp.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class DatabaseFactory(private val context: Context) {

    actual fun create(): SqlDriver =
        AndroidSqliteDriver(
            schema = NewsTestDatabase.Schema,
            context = context,
            name = "NewsTest.Database.db"
        )
}