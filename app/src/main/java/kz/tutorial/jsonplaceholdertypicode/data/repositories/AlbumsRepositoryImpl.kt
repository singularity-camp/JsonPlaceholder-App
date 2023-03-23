package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.mapper.toAlbum
import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumsRepository

class AlbumsRepositoryImpl(private val mainApi: MainApi) : AlbumsRepository {
    override suspend fun getAlbums(): List<Album> {
        val remoteAlbums = mainApi.getAlbums()
        val users = mainApi.getUsers()
        val albums = remoteAlbums.map { toAlbum(it) }.toMutableList()
        albums.forEachIndexed { index, item ->
            System.out.println("User = $item")
            val user = mainApi.getUser(item.userId)
            item.username = user.username
        }

        return albums
    }
}