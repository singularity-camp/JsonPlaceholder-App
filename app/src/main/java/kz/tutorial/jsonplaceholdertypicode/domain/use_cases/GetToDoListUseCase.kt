package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.ToDoListRepository

class GetToDoListUseCase(private val toDoListRepository: ToDoListRepository) {
    suspend operator fun invoke(userId: Int): List<ToDo> {
        return toDoListRepository.getToDoList(userId)
    }
}