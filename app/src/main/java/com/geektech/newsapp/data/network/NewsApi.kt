package com.geektech.newsapp.data.network

import NewsBase
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    fun fetchHeadlines(
        @Query("country") country: String,
        @Query("apiKey") key: String,
        @Query("pageSize") size: Int,
        @Query("page") page: Int
    ): Call<NewsBase>
}