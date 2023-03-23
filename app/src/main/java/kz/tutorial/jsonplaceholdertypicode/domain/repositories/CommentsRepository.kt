package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment

interface CommentsRepository {
    suspend fun getComments(id: Int): List<Comment>
}