package kz.tutorial.jsonplaceholdertypicode.domain

class GetCommentsUseCase(private val postsRepository: PostsRepository) {
    suspend operator fun invoke(postId : Int): List<Comment> {
        return postsRepository.getCommentsToPost(postId)
    }
}