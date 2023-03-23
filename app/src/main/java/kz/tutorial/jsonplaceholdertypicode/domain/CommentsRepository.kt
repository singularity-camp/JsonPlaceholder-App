package kz.tutorial.jsonplaceholdertypicode.domain

interface CommentsRepository {
    suspend fun getComments(id: Int): List<Comment>
}