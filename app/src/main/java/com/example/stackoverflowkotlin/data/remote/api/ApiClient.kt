package com.example.stackoverflowkotlin.data.remote.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        private const val BASE_URL = "https://api.stackexchange.com/2.3/"
        private var retrofit: Retrofit? = null
        private val gson = GsonBuilder()
            .setLenient()
            .create()

        fun getRetrofit(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit!!
        }

    }

}