package com.example.mvvmcleanmovies.di

import com.example.mvvmcleanmovies.domain.repository.MovieRepository
import com.example.mvvmcleanmovies.data.repository.MovieRepositoryImpl
import com.example.mvvmcleanmovies.data.service.APIClient
import com.example.mvvmcleanmovies.data.service.APIClientImpl
import com.example.mvvmcleanmovies.data.service.MovieService
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {
    factory<MovieRepository> {
        MovieRepositoryImpl(
            movieService = get()
        )
    }

    single {
        provideApiClient()
    }
    single {
        provideMovieService(
            retrofit = get()
        )
    }
    single {
        provideRetrofit(
            apiClient = get()
        )
    }
}

private fun provideApiClient(): APIClient =
    APIClientImpl()

private fun provideMovieService(retrofit: Retrofit): MovieService =
    retrofit.create(MovieService::class.java)

private fun provideRetrofit(apiClient: APIClient): Retrofit =
    apiClient.configure("https://api.themoviedb.org/3/")