package com.example.mvvmcleanmovies.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.example.mvvmcleanmovies.R
import com.example.mvvmcleanmovies.presentation.fragments.MoviesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContaineView, MoviesFragment.newInstance())
            .commitAllowingStateLoss()
    }
}