package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

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
    private val _postLiveData: MutableLiveData<Post> = MutableLiveData()
    val postLiveData: LiveData<Post> = _postLiveData

    private val _commentsLiveData: MutableLiveData<List<Comment>> = MutableLiveData()
    val commentsLiveData: LiveData<List<Comment>> = _commentsLiveData

    fun setPostID(ID: Int?) {
        if (ID != null) {
            viewModelScope.launch {
                val post = getPostDetailsUseCase(ID)
                _postLiveData.postValue(post)
            }
            viewModelScope.launch {
                val comments = getCommentsUseCase(ID)
                _commentsLiveData.postValue(comments)
            }
        }
    }
}