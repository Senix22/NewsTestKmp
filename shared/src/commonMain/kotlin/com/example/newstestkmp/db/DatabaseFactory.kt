package com.example.newstestkmp.db

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseFactory {

    fun create(): SqlDriver
}