package com.example.newstestkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform