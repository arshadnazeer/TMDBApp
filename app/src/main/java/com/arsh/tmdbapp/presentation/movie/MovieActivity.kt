package com.arsh.tmdbapp.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arsh.tmdbapp.R
import com.arsh.tmdbapp.databinding.ActivityMovieBinding
import com.arsh.tmdbapp.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieBinding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubcomponent()
            .inject(this)

        movieViewModel= ViewModelProvider(this,movieViewModelFactory).get(MovieViewModel::class.java)
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.i("TAGGG",it.toString())
        })

    }
}