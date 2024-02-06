package com.example.newstestkmp.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ArticlesResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val results: Int,
    @SerialName("articles")
    val articles: List<ArticleRaw>
)

@Serializable
data class ArticleRaw(
    @SerialName("title") val title : String,
    @SerialName("description") val description : String?,
    @SerialName("urlToImage") val urlToImage : String?,
    @SerialName("publishedAt") val publishedAt : String?,
)
