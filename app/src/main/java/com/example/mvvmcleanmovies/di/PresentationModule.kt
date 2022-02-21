package com.example.mvvmcleanmovies.di

import com.example.mvvmcleanmovies.presentation.viewmodels.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        MovieViewModel(
            movieUseCase = get()
        )
    }
}