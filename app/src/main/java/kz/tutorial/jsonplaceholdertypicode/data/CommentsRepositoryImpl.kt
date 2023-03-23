package kz.tutorial.jsonplaceholdertypicode.data

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.CommentsRepository

class CommentsRepositoryImpl(private val mainApi: MainApi) : CommentsRepository {
    override suspend fun getComments(id: Int): List<Comment> {
        return mainApi.getCommentsList(id)
    }
}