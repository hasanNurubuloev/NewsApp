package com.geektech.newsapp.ui.main

import NewsBase
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.newsapp.data.NewsRepository

class MainViewModel : ViewModel(){
    fun fetchNews(): LiveData<NewsBase> {
        Log.d("ololo", "fetchNews: ")
        return NewsRepository().fetchNews()
    }
}