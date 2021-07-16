package com.arsh.tmdbapp.presentation.di.tvshow

import com.arsh.tmdbapp.domain.usecase.*
import com.arsh.tmdbapp.presentation.artist.ArtistViewModel
import com.arsh.tmdbapp.presentation.artist.ArtistViewModelFactory
import com.arsh.tmdbapp.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule() {
    @TvShowScope
    @Provides
    fun providesTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowUseCase,updateTvShowUseCase)
    }
}