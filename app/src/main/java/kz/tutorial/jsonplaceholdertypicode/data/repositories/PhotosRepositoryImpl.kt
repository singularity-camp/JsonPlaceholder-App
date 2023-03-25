package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PhotosRepository

class PhotosRepositoryImpl(private val mainApi: MainApi) : PhotosRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return mainApi.getAlbumPhotos(albumId)
    }
}