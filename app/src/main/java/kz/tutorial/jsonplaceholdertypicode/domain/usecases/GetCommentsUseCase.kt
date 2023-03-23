package kz.tutorial.jsonplaceholdertypicode.domain.usecases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.CommentsRepository

class GetCommentsUseCase(private val commentsRepository: CommentsRepository) {
    suspend operator fun invoke(id: Int): List<Comment> {
        return commentsRepository.getComments(id)
    }
}