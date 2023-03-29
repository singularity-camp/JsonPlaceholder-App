package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo

interface ToDoListRepository {
    suspend fun getToDoList(userId: Int): List<ToDo>
}