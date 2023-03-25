package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumsRepository

class AlbumsRepositoryImpl(private val mainApi: MainApi) : AlbumsRepository {
    override suspend fun getAlbums(): List<Album> {
        val remoteAlbums = mainApi.getRemoteAlbums()
        val users = mainApi.getUsers()
        val photos = mainApi.getPhotos()

        val albums = remoteAlbums.map { remoteAlbum ->
            Album(
                id = remoteAlbum.id,
                userId = remoteAlbum.userId,
                title = remoteAlbum.title,
                username = "A",
                thumbnailUrl = "https://via.placeholder.com/150/92c952"
            )
        }

        return albums
    }
}