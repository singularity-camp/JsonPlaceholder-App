package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetAlbumByIdUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPhotosUseCase

private const val DEFAULT_SPAN_COUNT = 2

class PhotosViewModel(
    private val albumId: Int,
    private val getPhotosUseCase: GetPhotosUseCase,
    private val getAlbumByIdUseCase: GetAlbumByIdUseCase
) : ViewModel() {

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album> = _album

    private val _rvLayoutState = MutableLiveData<LayoutManager>()
    val rvLayoutState: LiveData<LayoutManager> = _rvLayoutState
    private var state = true

    private val _selectorBackground = MutableLiveData<Int>()
    val selectorBackground: LiveData<Int> = _selectorBackground
    private val background = listOf(R.drawable.iv_list, R.drawable.iv_grid)
    private var state2 = true

    init {
        getPhotos()
    }

    fun changeSelectorBackground() {
        if (state2) {
            _selectorBackground.value = background[0]
            state2 = !state2
        } else {
            _selectorBackground.value = background[1]
            state2 = !state2
        }
    }

    fun setLayoutManager(context: Context?) {
        if (context != null) {
            if (state) {
                _rvLayoutState.value = LinearLayoutManager(context)
                state = !state
            } else {
                _rvLayoutState.value = GridLayoutManager(context, DEFAULT_SPAN_COUNT)
                state = !state
            }
        }
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