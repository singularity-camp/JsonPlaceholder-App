package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.SubmitPostUseCase
import timber.log.Timber

class PostsViewModel(
    private val getPostsUseCase: GetPostsUseCase,
    private val submitPostUseCase: SubmitPostUseCase
) : ViewModel() {

    private val _postsLiveData: MutableLiveData<List<Post>> = MutableLiveData()
    val postsLiveData: LiveData<List<Post>> = _postsLiveData

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val posts = getPostsUseCase()
            _postsLiveData.postValue(posts)
            submitNewPost()
        }
    }

    private fun submitNewPost() {
        repeat(3) {
            viewModelScope.launch {
                val postInServer = submitPostUseCase.invoke(
                    userId = 1L,
                    title = "New Post",
                    body = "New Post Body"
                )
                Timber.e("Our submitted post = $postInServer")
            }
        }
    }

}