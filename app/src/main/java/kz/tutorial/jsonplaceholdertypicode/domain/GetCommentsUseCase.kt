package kz.tutorial.jsonplaceholdertypicode.domain

class GetCommentsUseCase(private val commentsRepository: CommentsRepository) {
    suspend operator fun invoke(id: Int): List<Comment> {
        return commentsRepository.getComments(id)
    }
}