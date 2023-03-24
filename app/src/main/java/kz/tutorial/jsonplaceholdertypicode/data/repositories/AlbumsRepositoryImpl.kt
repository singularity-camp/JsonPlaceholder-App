package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumRepository

class AlbumsRepositoryImpl(private val mainApi: MainApi) : AlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        return mainApi.getAlbums()
    }
}