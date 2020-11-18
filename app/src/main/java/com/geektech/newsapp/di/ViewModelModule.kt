package com.geektech.newsapp.di

import com.geektech.newsapp.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

