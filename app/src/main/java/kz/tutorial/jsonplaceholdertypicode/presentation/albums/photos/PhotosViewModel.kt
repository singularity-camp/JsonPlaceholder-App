package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetAlbumByIdUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPhotosUseCase

class PhotosViewModel(
    private val albumId: Int,
    private val getPhotosUseCase: GetPhotosUseCase,
    private val getAlbumByIdUseCase: GetAlbumByIdUseCase
) : ViewModel() {

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album> = _album

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            val photosList = getPhotosUseCase(albumId)
            _photos.postValue(photosList)
        }
        viewModelScope.launch {
            val album = getAlbumByIdUseCase(albumId)
            _album.postValue(album)
        }
    }
}