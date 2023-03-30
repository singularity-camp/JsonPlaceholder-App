package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.ToDoListRepository

class ToDoListRepositoryImpl(private val mainApi: MainApi) : ToDoListRepository {
    override suspend fun getToDoList(userId: Int): List<ToDo> {
        return mainApi.getToDoList(userId)
    }
}