package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.usecases.GetCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.usecases.GetPostDetailsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.usecases.GetUserUseCase

class PostDetailsViewModel(
    private val getPostDetailsUseCase: GetPostDetailsUseCase,
    private val getCommentsUseCase: GetCommentsUseCase,
    private val getUserUseCase: GetUserUseCase,
) : ViewModel() {
    private val _postLiveData: MutableLiveData<Post> = MutableLiveData()
    val postLiveData: LiveData<Post> = _postLiveData

    private val _commentsLiveData: MutableLiveData<List<Comment>> = MutableLiveData()
    val commentsLiveData: LiveData<List<Comment>> = _commentsLiveData

    private val _userLiveData: MutableLiveData<User> = MutableLiveData()
    val userLiveData: LiveData<User> = _userLiveData

    fun setPostID(ID: Int?) {
        if (ID != null) {
            viewModelScope.launch {
                val post = getPostDetailsUseCase(ID)
                val user = getUserUseCase(post.userId)
                _userLiveData.postValue(user)
                _postLiveData.postValue(post)
            }
            viewModelScope.launch {
                val comments = getCommentsUseCase(ID)
                _commentsLiveData.postValue(comments)
            }
        }
    }
}