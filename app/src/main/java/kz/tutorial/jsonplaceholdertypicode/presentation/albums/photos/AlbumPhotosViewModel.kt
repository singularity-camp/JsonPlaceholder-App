package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetAlbumPhotosUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetAlbumsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetRemoteAlbumByIdUseCase

class AlbumPhotosViewModel(
    private val albumId: Int,
    private val getAlbumPhotosUseCase: GetAlbumPhotosUseCase,
    private val getRemoteAlbumByIdUseCase: GetRemoteAlbumByIdUseCase
) : ViewModel() {

    private val _albumPhotos = MutableLiveData<List<Photo>>()
    val albumPhotos: LiveData<List<Photo>> = _albumPhotos

    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album> = _album

    init {
        getAlbumPhotos()
        getAlbum()
    }

    private fun getAlbumPhotos() {
        viewModelScope.launch {
            val albumPhotos = getAlbumPhotosUseCase(albumId)
            _albumPhotos.postValue(albumPhotos)
        }
    }

    private fun getAlbum() {
        viewModelScope.launch {
            val remoteAlbum = getRemoteAlbumByIdUseCase(albumId)
            _album.postValue(remoteAlbum)
        }
    }
}