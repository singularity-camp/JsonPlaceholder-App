package kz.tutorial.jsonplaceholdertypicode.presentation.users.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserUseCase

class UserProfileViewModel(
    private val userId: Int, private val currentId: Int, private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val _userProfile = MutableLiveData<User>()
    val userProfile: LiveData<User> = _userProfile

    private val _currentUser = MutableLiveData<Int>()
    val currentUser: LiveData<Int> = _currentUser

    init {
        identifyUser()
    }

    private fun identifyUser() {
        if (userId == 0) {
            _currentUser.value = currentId
            getUserProfile(currentId)
        } else {
            _currentUser.value = userId
            getUserProfile(userId)
        }
    }

    private fun getUserProfile(id: Int) {
        viewModelScope.launch {
            val user = getUserUseCase(id)
            _userProfile.postValue(user)
        }
    }
}