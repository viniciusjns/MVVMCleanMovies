package com.example.mvvmcleanmovies.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.mvvmcleanmovies.domain.mapper.toMovieUiModel
import com.example.mvvmcleanmovies.domain.model.Movie
import com.example.mvvmcleanmovies.domain.usecase.MovieUseCase
import com.example.mvvmcleanmovies.presentation.models.MovieUiModel
import kotlinx.coroutines.launch

class MovieViewModel(
    private val movieUseCase: MovieUseCase
): BaseViewModel() {

    val popularMoviesLiveData = MutableLiveData<List<MovieUiModel>>()

    fun getPopularMovies() {
        viewModelScope.launch {
            popularMoviesLiveData.value =
                movieUseCase.getPopularMovies().map {
                    it.toMovieUiModel()
                }
        }
    }

}