package kz.tutorial.jsonplaceholdertypicode.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserShort(
    val id: Int,
    val email: String,
    val name: String,
    val username: String,
) : Parcelable
