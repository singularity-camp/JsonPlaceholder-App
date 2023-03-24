package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.AlbumsWithUser
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetAlbumsWithUserUseCase

class AlbumsViewModel(private val getAlbumsUseCase: GetAlbumsWithUserUseCase) : ViewModel() {
    private val _albums = MutableLiveData<List<AlbumsWithUser>>()
    val albums: LiveData<List<AlbumsWithUser>> = _albums

    init {
        getAlbumsList()
    }

    private fun getAlbumsList() {
        viewModelScope.launch {
            val albumsList = getAlbumsUseCase()
            _albums.postValue(albumsList)
        }
    }
}