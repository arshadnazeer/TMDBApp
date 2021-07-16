package com.arsh.tmdbapp.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.arsh.tmdbapp.data.model.movies.Movie
import com.arsh.tmdbapp.domain.usecase.GetMoviesUseCase
import com.arsh.tmdbapp.domain.usecase.GetTvShowUseCase
import com.arsh.tmdbapp.domain.usecase.UpdateMovieUseCase
import com.arsh.tmdbapp.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val movieList = getTvShowUseCase.execute()
        emit(movieList)
    }

    fun updateTvShows() = liveData {
        val movieList = updateTvShowUseCase.execute()
        emit(movieList)
    }
}