package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.mapper.toAlbum
import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumsRepository

class AlbumsRepositoryImpl(private val mainApi: MainApi) : AlbumsRepository {
    override suspend fun getAlbums(): List<Album> {
        val remoteAlbums = mainApi.getAlbums()
        val users = mainApi.getUsers()
        val photos = mainApi.getAllPhotos()
        val albums = remoteAlbums.map { remoteAlbum ->
            val thisUser = users.find { user -> user.id == remoteAlbum.userId }
            val thisPhoto = photos.find { photo -> photo.albumId == remoteAlbum.id }
            toAlbum(remoteAlbum = remoteAlbum, user = thisUser, photo = thisPhoto)
        }

        return albums
    }

    override suspend fun getAlbumPhotos(albumId: Int): List<Photo> {
        return mainApi.getAlbumPhotos(albumId)
    }

    override suspend fun getAlbumById(albumId: Int): Album {
        val remoteAlbum = mainApi.getRemoteAlbumById(albumId)
        val users = mainApi.getUsers()
        val user = users.find { user -> user.id == remoteAlbum.userId }
        return Album(
            id = remoteAlbum.id,
            previewPhoto = "",
            userId = remoteAlbum.userId,
            title = remoteAlbum.title,
            username = user?.username ?: ""
        )
    }
}