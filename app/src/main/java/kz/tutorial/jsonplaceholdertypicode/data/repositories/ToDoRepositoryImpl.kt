package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.ToDoRepository

class ToDoRepositoryImpl(private val mainApi: MainApi) : ToDoRepository {
    override suspend fun getTodo(userId: Int): List<ToDo> {
        return mainApi.getTodo(userId)
    }
}