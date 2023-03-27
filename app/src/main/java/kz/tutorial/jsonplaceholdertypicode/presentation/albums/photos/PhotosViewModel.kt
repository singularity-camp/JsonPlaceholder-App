package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPhotosUseCase

class PhotosViewModel(private val getPhotosUseCase: GetPhotosUseCase) : ViewModel() {
    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    fun getPhotos(albumId: Int) {
        viewModelScope.launch {
            val photosList = getPhotosUseCase(albumId)
            _photos.postValue(photosList)
        }
    }
}