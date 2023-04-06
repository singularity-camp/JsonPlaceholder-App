package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.repositories.CommentsRepository
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment

class GetCommentsUseCase(private val commentsRepository: CommentsRepository) {
    suspend operator fun invoke(postId: Int): List<Comment> {
        return commentsRepository.getComments(postId)
    }
}