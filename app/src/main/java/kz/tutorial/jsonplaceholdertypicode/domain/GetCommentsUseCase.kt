package kz.tutorial.jsonplaceholdertypicode.domain

class GetCommentsUseCase(private val commentsRepository: PostsRepository) {
    suspend operator fun invoke(postId: Int): List<Comment> {
        return commentsRepository.getComments(postId)
    }
}