package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo

interface AlbumsRepository {
    suspend fun getAlbums() : List<Album>

    suspend fun getAlbumPhotos(albumId: Int) : List<Photo>

    suspend fun getAlbumById(albumId: Int) : Album
}