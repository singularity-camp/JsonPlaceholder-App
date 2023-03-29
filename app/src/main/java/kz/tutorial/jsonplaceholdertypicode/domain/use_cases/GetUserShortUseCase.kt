package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.UserShort
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.UserRepository

class GetUserShortUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(): List<UserShort> {
        return userRepository.getUsersShort()
    }
}