package kz.tutorial.jsonplaceholdertypicode.presentation.users.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetToDoUseCase

class ToDoViewModel(private val userId: Int, private val getToDoUseCase: GetToDoUseCase) :
    ViewModel() {
    private val _todos = MutableLiveData<List<ToDo>>()
    val todos: LiveData<List<ToDo>> = _todos

    init {
        getTodos()
    }

    private fun getTodos() {
        viewModelScope.launch {
            val todoList = getToDoUseCase(userId)
            _todos.postValue(todoList)
        }
    }
}