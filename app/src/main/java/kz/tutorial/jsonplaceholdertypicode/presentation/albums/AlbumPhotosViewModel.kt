package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetAlbumPhotosUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetAlbumsUseCase

class AlbumPhotosViewModel(private val albumId : Int, private val getAlbumPhotosUseCase: GetAlbumPhotosUseCase) : ViewModel() {
    private val _photosLiveData: MutableLiveData<List<Photo>> = MutableLiveData()
    val photosLiveData: LiveData<List<Photo>> = _photosLiveData

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            val photos = getAlbumPhotosUseCase(albumId)
            _photosLiveData.postValue(photos)
        }
    }
}