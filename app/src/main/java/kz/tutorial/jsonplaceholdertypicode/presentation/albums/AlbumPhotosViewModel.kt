package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetAlbumByIdUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetAlbumPhotosUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetAlbumsUseCase

class AlbumPhotosViewModel(private val albumId : Int,
                           private val getAlbumPhotosUseCase: GetAlbumPhotosUseCase,
                            private val getAlbumByIdUseCase: GetAlbumByIdUseCase) : ViewModel() {
    private val _photosLiveData: MutableLiveData<List<Photo>> = MutableLiveData()
    val photosLiveData: LiveData<List<Photo>> = _photosLiveData

    private val _currAlbumLiveData : MutableLiveData<Album> = MutableLiveData()
    val currAlbumLiveData : LiveData<Album> = _currAlbumLiveData

    init {
        getPhotos()
        getAlbumInfo()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            val photos = getAlbumPhotosUseCase(albumId)
            _photosLiveData.postValue(photos)
        }
    }

    private fun getAlbumInfo() {
        viewModelScope.launch {
            val album = getAlbumByIdUseCase(albumId)
            _currAlbumLiveData.postValue(album)
        }
    }
}