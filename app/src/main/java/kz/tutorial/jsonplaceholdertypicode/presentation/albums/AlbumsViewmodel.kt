package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetAlbumsUseCase

class AlbumsViewmodel(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {
    private val _albumsLiveData: MutableLiveData<List<Album>> = MutableLiveData()
    val albumsLiveData: LiveData<List<Album>> = _albumsLiveData

    init {
        getAlbums()
    }

    private fun getAlbums() {
        viewModelScope.launch {
            val albums = getAlbumsUseCase()
            _albumsLiveData.postValue(albums)
        }
    }
}