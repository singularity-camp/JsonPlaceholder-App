package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostDetailsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserUseCase

class PostDetailsViewModel(
    private val postId: Int,
    private val getPostDetailsUseCase: GetPostDetailsUseCase,
    private val getCommentsUseCase: GetCommentsUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post> = _post

    private val _author = MutableLiveData<User>()
    val author: LiveData<User> = _author

    private val _comments = MutableLiveData<List<Comment>>()
    val comments: LiveData<List<Comment>> = _comments

    init {
        getPostDetails()
        getComments()
    }

    private fun getPostDetails() {
        viewModelScope.launch {
            val postDetails = getPostDetailsUseCase(postId)
            _post.postValue(postDetails)
            getAuthor(userId = postDetails.userId)
        }
    }

    private fun getAuthor(userId: Int) {
        viewModelScope.launch {
            val authorDetails = getUserUseCase(userId)
            _author.postValue(authorDetails)
        }
    }

    private fun getComments() {
        viewModelScope.launch {
            val commentsList = getCommentsUseCase(postId = postId)
            _comments.postValue(commentsList)
        }
    }
}