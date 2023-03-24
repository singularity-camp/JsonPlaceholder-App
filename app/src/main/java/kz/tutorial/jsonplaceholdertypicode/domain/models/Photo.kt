package kz.tutorial.jsonplaceholdertypicode.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo(
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String,
) : Parcelable
