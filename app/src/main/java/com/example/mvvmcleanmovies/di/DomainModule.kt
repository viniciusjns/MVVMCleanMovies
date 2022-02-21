package com.example.mvvmcleanmovies.di

import com.example.mvvmcleanmovies.domain.usecase.MovieUseCase
import com.example.mvvmcleanmovies.domain.usecase.MovieUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<MovieUseCase> {
        MovieUseCaseImpl(
            movieRepository = get()
        )
    }
}