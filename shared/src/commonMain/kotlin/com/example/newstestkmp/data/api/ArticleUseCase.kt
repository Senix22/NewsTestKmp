package com.example.newstestkmp.data.api

import ArticlesRepository
import com.example.newstestkmp.Article
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticleUseCase(private val repo: ArticlesRepository) {


    suspend fun getArticles(): List<Article> {
        return mapper(repo.getArticles(false))
    }

    private fun mapper(articlesResponse: List<ArticleRaw>): List<Article> =
        articlesResponse.map { article ->
            Article(
                title = article.title,
                desc = article.description.orEmpty(),
                date =(article.publishedAt.orEmpty()),
                imageUrl = article.urlToImage.orEmpty()
            )
        }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}