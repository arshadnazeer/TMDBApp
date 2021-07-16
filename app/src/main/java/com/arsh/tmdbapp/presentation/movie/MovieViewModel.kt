package com.arsh.tmdbapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.arsh.tmdbapp.data.model.movies.Movie
import com.arsh.tmdbapp.domain.usecase.GetMoviesUseCase
import com.arsh.tmdbapp.domain.usecase.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        // using main thread here to call the data source that is in IO thread
        // data source is using -> corouine , different thread
        val movieList = getMoviesUseCase.exexute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }
}