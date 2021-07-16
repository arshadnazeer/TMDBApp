package com.arsh.tmdbapp.presentation.di.movie

import com.arsh.tmdbapp.presentation.artist.ArtistActivity
import com.arsh.tmdbapp.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
// using the subcomponent to inject dependencies to artist activity
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}