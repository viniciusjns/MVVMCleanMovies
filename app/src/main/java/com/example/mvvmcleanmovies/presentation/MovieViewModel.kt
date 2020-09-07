package com.example.mvvmcleanmovies.presentation

import androidx.lifecycle.MutableLiveData
import com.example.mvvmcleanmovies.domain.model.Movie
import com.example.mvvmcleanmovies.domain.usecase.MovieUseCase
import kotlinx.coroutines.launch

class MovieViewModel(
    private val movieUseCase: MovieUseCase
): BaseViewModel() {

    val popularMoviesLiveData = MutableLiveData<List<Movie>>()

    fun getPopularMovies() {
        viewModelScope.launch {
            runCatching {
                popularMoviesLiveData.value = movieUseCase.getPopularMovies()
            }.onFailure {

            }
        }
    }

}