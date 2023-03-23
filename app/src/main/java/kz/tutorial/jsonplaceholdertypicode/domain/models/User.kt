package kz.tutorial.jsonplaceholdertypicode.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kz.tutorial.jsonplaceholdertypicode.domain.models.Address
import kz.tutorial.jsonplaceholdertypicode.domain.models.Company

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company,
) : Parcelable
