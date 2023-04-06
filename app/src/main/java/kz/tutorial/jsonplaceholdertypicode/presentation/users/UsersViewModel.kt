package kz.tutorial.jsonplaceholdertypicode.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUsersUseCase

class UsersViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            val usersList = getUsersUseCase()
            _users.postValue(usersList)
        }
    }
}