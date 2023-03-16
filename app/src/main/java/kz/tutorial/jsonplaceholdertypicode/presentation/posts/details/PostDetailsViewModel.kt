package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.Post

class PostDetailsViewModel : ViewModel() {
    private val _postLiveData: MutableLiveData<Post> = MutableLiveData()
    val postLiveData: LiveData<Post> = _postLiveData

    init {
        getPost()
    }

    private fun getPost() {
        viewModelScope.launch {
            val post : Post = PostRetrofitBuilder.postAPIService.getPostsOne()
            _postLiveData.postValue(post)
        }
    }
}