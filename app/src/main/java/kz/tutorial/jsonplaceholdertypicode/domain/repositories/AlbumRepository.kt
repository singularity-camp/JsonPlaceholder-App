package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.Album

interface AlbumRepository {
    suspend fun getAlbums(): List<Album>
}