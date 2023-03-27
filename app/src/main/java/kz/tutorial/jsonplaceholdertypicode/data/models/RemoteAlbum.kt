package kz.tutorial.jsonplaceholdertypicode.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RemoteAlbum(
    val id: Int,
    val userId: Int,
    val title: String,
) : Parcelable

