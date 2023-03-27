package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumsRepository

class AlbumsRepositoryImpl(private val mainApi: MainApi) : AlbumsRepository {
    override suspend fun getAlbums(): List<Album> {
        val remoteAlbums = mainApi.getRemoteAlbums()
        val users = mainApi.getUsers()
        val photos = mainApi.getAllPhotos()

        val albums = remoteAlbums.map { remoteAlbum ->
            val user = users.find { user -> user.id == remoteAlbum.userId }
            val photo = photos.find { photo -> photo.albumId == remoteAlbum.id }
            Album(
                id = remoteAlbum.id,
                userId = remoteAlbum.userId,
                title = remoteAlbum.title,
                username = user?.username ?: "",
                thumbnailUrl = photo?.thumbnailUrl ?: ""
            )
        }

        return albums
    }
}