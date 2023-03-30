package kz.tutorial.jsonplaceholdertypicode.data

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.CommentsRepository

class CommentsRepositoryImpl(private val mainApi: MainApi) : CommentsRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        return mainApi.getComments(postId = postId.toString())
    }
}