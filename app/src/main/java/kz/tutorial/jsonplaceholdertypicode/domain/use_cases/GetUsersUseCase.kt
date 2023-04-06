package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.UsersRepository

class GetUsersUseCase(private val usersRepository: UsersRepository) {
    suspend operator fun invoke(): List<User> {
        return usersRepository.getUsers()
    }
}