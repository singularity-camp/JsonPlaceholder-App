package kz.tutorial.jsonplaceholdertypicode.domain.usecases

import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.UsersRepository

class GetUserUseCase(private val usersRepository: UsersRepository) {
    suspend operator fun invoke(id: Int) : User {
        return usersRepository.getUser(id)
    }
}