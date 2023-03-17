package kz.tutorial.jsonplaceholdertypicode.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class  Comment(
    val postId : String,
    val id : String,
    val name : String,
    val email : String,
    val body : String
) : Parcelable