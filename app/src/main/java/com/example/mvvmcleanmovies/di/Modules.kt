package com.example.mvvmcleanmovies.di

import com.example.mvvmcleanmovies.data.service.APIClient
import com.example.mvvmcleanmovies.data.service.APIClientImpl
import com.example.mvvmcleanmovies.data.service.MovieService
import com.example.mvvmcleanmovies.data.repository.MovieRepository
import com.example.mvvmcleanmovies.data.repository.MovieRepositoryImpl
import com.example.mvvmcleanmovies.presentation.viewmodels.MovieViewModel
import com.example.mvvmcleanmovies.domain.usecase.MovieUseCase
import com.example.mvvmcleanmovies.domain.usecase.MovieUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val vieModelModule = module {
    viewModel {
        MovieViewModel(
            get()
        )
    }
}

val useCaseModule = module {
    factory<MovieUseCase> { return@factory MovieUseCaseImpl(get()) }
}

val repositoryModule = module {
    factory<MovieRepository> {
        return@factory MovieRepositoryImpl(get())
    }
}

val networkModule = module {
    single { provideApiClient() }
    single { provideMovieService(get()) }
    single { provideRetrofit(get()) }
}

fun provideApiClient(): APIClient =
    APIClientImpl()

fun provideMovieService(retrofit: Retrofit): MovieService =
    retrofit.create(MovieService::class.java)

fun provideRetrofit(apiClient: APIClient): Retrofit =
    apiClient.configure("https://api.themoviedb.org/3/")