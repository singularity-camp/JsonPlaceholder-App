package kz.tutorial.jsonplaceholdertypicode.presentation.posts.comments

import kz.tutorial.jsonplaceholdertypicode.constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommentRetrofitBuilder {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val commentAPIService: IFCommentAPI = getRetrofit().create(IFCommentAPI::class.java)
}