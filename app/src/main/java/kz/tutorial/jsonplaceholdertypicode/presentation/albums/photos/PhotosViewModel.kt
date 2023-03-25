package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo

class PhotosViewModel() : ViewModel() {
    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album> = _album


    fun getPhotos(albumId: Int?) {
        if (albumId != null) {
            viewModelScope.launch {
            }
        }
    }
}