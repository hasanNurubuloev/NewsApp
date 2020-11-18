package com.geektech.newsapp.di

import com.geektech.newsapp.data.network.RetrofitClient
import org.koin.dsl.module

var networkModule = module {
    single { RetrofitClient(get()) }
}