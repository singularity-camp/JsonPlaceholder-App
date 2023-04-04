package kz.tutorial.jsonplaceholdertypicode.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUsersUseCase

class UsersFragmentViewmodel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {
    private val _usersLiveData : MutableLiveData<List<User>> = MutableLiveData()
    val usersLiveData : LiveData<List<User>> = _usersLiveData

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            val users = getUsersUseCase()
            _usersLiveData.postValue(users)
        }
    }
}