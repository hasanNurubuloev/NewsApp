package com.geektech.newsapp.data

import NewsBase
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.newsapp.data.network.NewsApi
import com.geektech.newsapp.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    private val apiKey = "9f9e02b083c0405fb779efeaec0bbe6f"
    private val pageSize = 10
    private val page = 3
    private val country = "us"
    private var apiService: NewsApi? = null

    fun fetchNews(): LiveData<NewsBase> {
        apiService = RetrofitClient.create()
        Log.d("ololo", "fetchNews: ")
        val data = MutableLiveData<NewsBase>()
        apiService?.fetchHeadlines(country, apiKey, pageSize, page)
            ?.enqueue(object : Callback<NewsBase> {
                override fun onResponse(call: Call<NewsBase>, response: Response<NewsBase>) {
                    data.value = response.body()
                    Log.d("ololo", "onResponse: "+response.body())

                }

                override fun onFailure(call: Call<NewsBase>, t: Throwable) {
                    data.value = null
                }
            })

        return data
    }
}