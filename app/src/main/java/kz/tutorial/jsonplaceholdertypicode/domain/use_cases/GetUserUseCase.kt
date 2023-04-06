package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(userId: Int) : User {
        return userRepository.getUser(userId)
    }
}