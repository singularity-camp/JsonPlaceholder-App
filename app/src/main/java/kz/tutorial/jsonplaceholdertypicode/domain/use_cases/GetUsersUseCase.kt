package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.UserRepository

class GetUsersUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke() : List<User> {
        return userRepository.getUsers()
    }
}