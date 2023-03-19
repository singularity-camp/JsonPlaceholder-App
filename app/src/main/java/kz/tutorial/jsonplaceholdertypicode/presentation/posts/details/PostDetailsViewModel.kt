package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostByIdUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserUseCase

private const val COMMENTS_LIMIT = 5

class PostDetailsViewModel(
    private val postId: Int,
    private val getPostByIdUseCase: GetPostByIdUseCase,
    private val getPostCommentsUseCase: GetPostCommentsUseCase,
    private val getUserUseCase: GetUserUseCase,
) : ViewModel() {

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post> = _post

    private val _author = MutableLiveData<User>()
    val author: LiveData<User> = _author

    private val _comments = MutableLiveData<List<Comment>>()
    val comments: LiveData<List<Comment>> = _comments


    init {
        getPost()
        getRecentPostComments()
    }

    private fun getPost() {
        viewModelScope.launch {
            val postDetails = getPostByIdUseCase(postId)
            _post.postValue(postDetails)

            //В целом, как один из вариантов, мы можем передавать userId сразу
            // в конструкторе и вызывать функцию ниже сразу в ините
            getAuthor(userId = postDetails.userId)
        }
    }

    private fun getAuthor(userId: Int) {
        viewModelScope.launch {
            val authorDetails = getUserUseCase(userId)
            _author.postValue(authorDetails)
        }
    }

    private fun getRecentPostComments() {
        viewModelScope.launch {
            val commentsList = getPostCommentsUseCase(postId = postId, limitBy = COMMENTS_LIMIT)
            _comments.postValue(commentsList)
        }
    }

}