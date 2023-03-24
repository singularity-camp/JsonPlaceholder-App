package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.AlbumsWithUser
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumRepository
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.UserRepository

class GetAlbumsWithUserUseCase(
    private val getAlbumRepository: AlbumRepository,
    private val getUserRepository: UserRepository
) {

    suspend operator fun invoke(): List<AlbumsWithUser> {
        val albumsWithUser: MutableList<AlbumsWithUser> = mutableListOf()
        val albums = getAlbumRepository.getAlbums()
        for (album in albums) {
            val user = getUserRepository.getUser(album.userId)
            val albumWithUser = AlbumsWithUser(album.title, user.username)
            albumsWithUser.add(albumWithUser)
        }
        return albumsWithUser
    }

}