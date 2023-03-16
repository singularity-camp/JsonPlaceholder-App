package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import kz.tutorial.jsonplaceholdertypicode.constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostRetrofitBuilder {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val postAPIService: IFPostAPI = getRetrofit().create(IFPostAPI::class.java)
}