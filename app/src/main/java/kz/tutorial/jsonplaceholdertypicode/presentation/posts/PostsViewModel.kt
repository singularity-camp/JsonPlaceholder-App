package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.Post
import kz.tutorial.jsonplaceholdertypicode.PostsRepository

class PostsViewModel(private val postsRepository: PostsRepository) : ViewModel() {

    private val _postsLiveData: MutableLiveData<List<Post>> = MutableLiveData()
    val postsLiveData: LiveData<List<Post>> = _postsLiveData

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val posts = postsRepository.getPosts()
            _postsLiveData.postValue(posts)
        }
    }

}