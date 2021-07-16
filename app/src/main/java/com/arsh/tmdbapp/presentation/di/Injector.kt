package com.arsh.tmdbapp.presentation.di

import com.arsh.tmdbapp.presentation.di.artist.ArtistSubComponent
import com.arsh.tmdbapp.presentation.di.movie.MovieSubComponent
import com.arsh.tmdbapp.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubcomponent():MovieSubComponent
    fun createTvShowSubcomponent():TvShowSubComponent
    fun createArtistSubcomponent():ArtistSubComponent
}