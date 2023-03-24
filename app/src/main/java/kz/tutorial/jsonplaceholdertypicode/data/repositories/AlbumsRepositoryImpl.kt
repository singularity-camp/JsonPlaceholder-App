package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.mapper.toAlbum
import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumsRepository

class AlbumsRepositoryImpl(private val mainApi: MainApi) : AlbumsRepository {
    override suspend fun getAlbums(): List<Album> {
        val remoteAlbums = mainApi.getAlbums()
        val users = mainApi.getUsers()
        val photos = mainApi.getAllPhotos()
        val albums = remoteAlbums.map { remoteAlbum ->
            val correspondingUser = users.find { user -> user.id == remoteAlbum.userId}
            val correspondingPhoto = photos.find { photo -> photo.albumId == remoteAlbum.id }
            toAlbum(remoteAlbum = remoteAlbum, user = correspondingUser, photo = correspondingPhoto)
        }

        return albums
    }
}