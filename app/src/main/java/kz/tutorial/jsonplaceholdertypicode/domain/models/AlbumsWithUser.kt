package kz.tutorial.jsonplaceholdertypicode.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlbumsWithUser(
    val cover: String,
    val title: String,
    val userName: String
) : Parcelable