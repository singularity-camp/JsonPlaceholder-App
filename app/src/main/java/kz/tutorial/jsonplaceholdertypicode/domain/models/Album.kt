package kz.tutorial.jsonplaceholdertypicode.domain.models


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    val id: Int,
    var previewPhoto: String,
    val title: String,
    val userId: Int,
    var username: String,
) : Parcelable