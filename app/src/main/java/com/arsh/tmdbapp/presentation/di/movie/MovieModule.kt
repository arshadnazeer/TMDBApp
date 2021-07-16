package com.arsh.tmdbapp.presentation.di.movie

import com.arsh.tmdbapp.domain.usecase.GetArtistUseCase
import com.arsh.tmdbapp.domain.usecase.GetMoviesUseCase
import com.arsh.tmdbapp.domain.usecase.UpdateArtistUseCase
import com.arsh.tmdbapp.domain.usecase.UpdateMovieUseCase
import com.arsh.tmdbapp.presentation.artist.ArtistViewModel
import com.arsh.tmdbapp.presentation.artist.ArtistViewModelFactory
import com.arsh.tmdbapp.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule() {
    @MovieScope
    @Provides
    fun providesMoviesViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase,updateMovieUseCase)
    }
}