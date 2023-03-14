package kz.tutorial.jsonplaceholdertypicode.domain

class GetPostsUseCase(private val postsRepository: PostsRepository) {
    suspend operator fun invoke(): List<Post> {
        return postsRepository.getPosts()
    }
}