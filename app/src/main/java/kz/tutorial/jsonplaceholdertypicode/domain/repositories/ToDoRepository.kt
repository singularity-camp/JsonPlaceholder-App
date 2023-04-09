package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo


interface ToDoRepository {
    suspend fun getTodo(userId: Int): List<ToDo>
}