package kz.tutorial.jsonplaceholdertypicode.presentation.posts.comments

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String,
) : Parcelable