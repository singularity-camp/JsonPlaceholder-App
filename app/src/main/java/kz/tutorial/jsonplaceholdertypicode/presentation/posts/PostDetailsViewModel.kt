package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.GetCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.GetPostDetailsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.Post

class PostDetailsViewModel(
    private val getPostDetailsUseCase: GetPostDetailsUseCase,
    private val getCommentsUseCase: GetCommentsUseCase
) : ViewModel() {

    private val _postDetailsLiveData: MutableLiveData<Post> = MutableLiveData()
    val postDetailsLiveData: LiveData<Post> = _postDetailsLiveData
    var id: Int = 1

    private val _commentsLiveData: MutableLiveData<List<Comment>> = MutableLiveData()
    val commentsLiveData: LiveData<List<Comment>> = _commentsLiveData

    init {
        getPostDetails(id)
        getComments(id)
    }

    private fun getPostDetails(id: Int) {
        viewModelScope.launch {
            val post = getPostDetailsUseCase(id = id)
            _postDetailsLiveData.postValue(post)

        }
    }

    private fun getComments(postId: Int) {
        viewModelScope.launch {
            val comments = getCommentsUseCase(postId)
            _commentsLiveData.postValue(comments)
        }
    }
}