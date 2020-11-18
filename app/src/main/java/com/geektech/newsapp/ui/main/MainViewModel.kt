package com.geektech.newsapp.ui.main

import NewsBase
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.newsapp.data.NewsRepository
import com.geektech.newsapp.data.network.Resource
import retrofit2.Call

class MainViewModel(private val newsRepository : NewsRepository) : ViewModel(){

    fun fetchNews(): LiveData<Resource<Call<NewsBase>?>> {
        return newsRepository.fetchNews()
    }
}