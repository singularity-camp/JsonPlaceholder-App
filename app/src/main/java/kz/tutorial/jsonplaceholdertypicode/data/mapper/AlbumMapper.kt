package kz.tutorial.jsonplaceholdertypicode.data.mapper

import kz.tutorial.jsonplaceholdertypicode.data.models.RemoteAlbum
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album

fun toAlbum(remoteAlbum: RemoteAlbum): Album {
    return Album(
        id = remoteAlbum.id,
        previewPhoto = "",
        title = remoteAlbum.title,
        userId = 0,
        username = ""
    )
}