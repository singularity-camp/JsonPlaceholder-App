package kz.tutorial.jsonplaceholdertypicode.presentation.users.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserUseCase

class UserProfileViewModel(
    private val userId: Int,
    private val currentUserId: Int,
    private val getUserUseCase: GetUserUseCase
) :
    ViewModel() {
    private val _userProfile = MutableLiveData<User>()
    val userProfile: LiveData<User> = _userProfile

    private val _currentUserID = MutableLiveData<Int>()
    val currentUserID: LiveData<Int> = _currentUserID

    init {
        verifyUser()
    }

    private fun verifyUser() {
        if (userId == 0) {
            _currentUserID.value = currentUserId
            getUserProfile(currentUserId)
        } else {
            _currentUserID.value = userId
            getUserProfile(userId)
        }
    }

    private fun getUserProfile(id: Int) {
        viewModelScope.launch {
            val user = getUserUseCase(userId = id)
            _userProfile.postValue(user)
        }
    }
}