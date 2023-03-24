package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.User

interface UsersRepository {
    suspend fun getUsers() : List<User>
}