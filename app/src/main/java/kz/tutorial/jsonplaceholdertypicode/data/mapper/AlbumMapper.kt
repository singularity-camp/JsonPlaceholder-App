package kz.tutorial.jsonplaceholdertypicode.data.mapper

import kz.tutorial.jsonplaceholdertypicode.data.models.RemoteAlbum
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.models.User

fun toAlbum(remoteAlbum: RemoteAlbum, user: User? = null, photo: Photo? = null): Album {
    return Album(
        id = remoteAlbum.id,
        previewPhoto = photo?.thumbnailUrl ?: "",
        title = remoteAlbum.title,
        userId = remoteAlbum.userId,
        username = user?.username ?: ""
    )
}