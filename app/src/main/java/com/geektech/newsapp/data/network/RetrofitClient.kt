package com.geektech.newsapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient (){
    companion object {
        private const val BASE_URL = "https://newsapi.org/v2/"

        fun create(): NewsApi? {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(NewsApi::class.java)
        }
    }
}