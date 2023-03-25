package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo

interface PhotosRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}