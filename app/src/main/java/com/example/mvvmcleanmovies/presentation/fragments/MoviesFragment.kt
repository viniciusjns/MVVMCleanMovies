package com.example.mvvmcleanmovies.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.mvvmcleanmovies.R
import com.example.mvvmcleanmovies.presentation.viewmodels.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private lateinit var tvMovies: TextView
    private val movieViewModel: MovieViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvMovies = requireActivity().findViewById(R.id.tvMovies)

        movieViewModel.getPopularMovies()

        movieViewModel.popularMoviesLiveData.observe(requireActivity(), Observer { movies ->
            tvMovies.text = movies.map { "${it.title}\n" }.toString()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies, container, false)

    companion object {
        @JvmStatic
        fun newInstance() = MoviesFragment()
    }
}