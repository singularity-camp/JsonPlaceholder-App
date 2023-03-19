package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.CommentsRepository

private const val NO_LIMIT = -1

class GetPostCommentsUseCase(private val commentsRepository: CommentsRepository) {
    suspend operator fun invoke(postId: Int, limitBy: Int = NO_LIMIT): List<Comment> {
        if (limitBy == NO_LIMIT || limitBy < 0) {
            return commentsRepository.getPostComments(postId)
        }

        //This takes first limitBy elements
        return commentsRepository.getPostComments(postId).take(limitBy)
    }

}