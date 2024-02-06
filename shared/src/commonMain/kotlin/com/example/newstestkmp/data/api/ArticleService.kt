package com.example.newstestkmp.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient: HttpClient) {
    private val apiKey ="435149dee83241479ddd0c3c8672cef9"
    suspend fun getArticles() : List<ArticleRaw>{
        val response :ArticlesResponse  = httpClient.get("https://newsapi.org/v2/everything?domains=wsj.com&apiKey=$apiKey").body()
        return response.articles
    }
}