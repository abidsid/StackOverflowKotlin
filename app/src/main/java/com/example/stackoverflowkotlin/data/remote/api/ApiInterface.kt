package com.example.stackoverflowkotlin.data.remote.api

import com.example.stackoverflowkotlin.data.remote.response.QuestionList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("Accept: application/json")
    @GET("search/advanced")
    fun getQuestionsList(
        @Query("fromdate") fromDate: Long,
        @Query("order") order: String,
        @Query("sort") sort: String,
        @Query("accepted") accepted: String,
        @Query("answers") answers: Int,
        @Query("site") stackoverflow: String
    ): Call<QuestionList>

}