package com.geektech.newsapp.di

import com.geektech.newsapp.data.NewsRepository
import org.koin.dsl.module

var repositoryModule = module{
    factory{NewsRepository(get())}
}