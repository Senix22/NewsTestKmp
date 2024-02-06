import com.example.newstestkmp.ArticleDataSource
import com.example.newstestkmp.data.api.ArticleRaw
import com.example.newstestkmp.data.api.ArticleService
import com.example.newstestkmp.data.api.ArticleUseCase


class ArticlesRepository(private val dataSource: ArticleDataSource, private val api: ArticleService) {

    suspend fun getArticles(isForceFetch : Boolean) : List<ArticleRaw> {
        if(isForceFetch){
            dataSource.clearArticles()
            return getArticles()
        }
        val articlesDb = dataSource.getAllArticles()

        if (articlesDb.isEmpty()) {

            return getArticles()
        }

        return articlesDb
    }

    private suspend fun getArticles(): List<ArticleRaw> {
        val fetchedArticles = api.getArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}