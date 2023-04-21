package kz.tutorial.jsonplaceholdertypicode.data.models

data class PostRequest(
    val userId: Long,
    val title: String,
    val body: String,
)