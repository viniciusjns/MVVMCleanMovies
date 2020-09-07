package com.example.mvvmcleanmovies.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mvvmcleanmovies.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieViewModel.getPopularMovies()

        movieViewModel.popularMoviesLiveData.observe(this, Observer {

        })
    }
}