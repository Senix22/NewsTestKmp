package com.example.newstestkmp.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DatabaseFactory() {

    actual fun create(): SqlDriver =
        NativeSqliteDriver(
            schema = NewsTestDatabase.Schema,
            name = "NewsTest.Database.db"
        )
}