package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.AlbumsWithUser
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumRepository
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PhotosRepository
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.UserRepository

class GetAlbumsWithUserUseCase(
    private val getAlbumRepository: AlbumRepository,
    private val getUserRepository: UserRepository,
    private val getPhotosRepository: PhotosRepository,
) {

    suspend operator fun invoke(): List<AlbumsWithUser> {
        val albumsWithUser: MutableList<AlbumsWithUser> = mutableListOf()
        val albums = getAlbumRepository.getAlbums()
        for (album in albums) {
            val cover = getPhotosRepository.getCover(album.id)
            val user = getUserRepository.getUser(album.userId)
            val albumWithUser = AlbumsWithUser(cover.url, album.title, user.username)
            albumsWithUser.add(albumWithUser)
        }
        return albumsWithUser
    }

}