package kz.tutorial.jsonplaceholdertypicode.domain

class GetPostDetailsUseCase(private val postDetailsRepository: PostsRepository) {
    suspend operator fun invoke(id: Int): Post {
        return postDetailsRepository.getPost(id)
    }
}