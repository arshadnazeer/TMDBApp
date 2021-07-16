package com.arsh.tmdbapp.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arsh.tmdbapp.domain.usecase.GetMoviesUseCase
import com.arsh.tmdbapp.domain.usecase.GetTvShowUseCase
import com.arsh.tmdbapp.domain.usecase.UpdateMovieUseCase
import com.arsh.tmdbapp.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase,updateTvShowUseCase) as T
    }

}