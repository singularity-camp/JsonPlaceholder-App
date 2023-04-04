package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.Album

interface AlbumsRepository {
    suspend fun getAlbums() : List<Album>
}