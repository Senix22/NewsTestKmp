package com.example.newstestkmp

import com.example.newstestkmp.data.api.ArticleRaw
import com.example.newstestkmp.db.Article
import com.example.newstestkmp.db.NewsTestDatabase

class ArticleDataSource(private val db: NewsTestDatabase) {

    fun getAllArticles(): List<ArticleRaw> =
        db.newsKmpDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        db.newsKmpDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() =
        db.newsKmpDatabaseQueries.removeAllArticles()

    private fun insertArticle(articleRaw: ArticleRaw) {
        db.newsKmpDatabaseQueries.insertArticle(
            articleRaw.title,
            articleRaw.description,
            articleRaw.publishedAt.orEmpty(),
            articleRaw.urlToImage

        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ): ArticleRaw =
        ArticleRaw(
            title,
            desc,
            date,
            url
        )

}