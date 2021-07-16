package com.arsh.tmdbapp.presentation.di.tvshow

import com.arsh.tmdbapp.presentation.artist.ArtistActivity
import com.arsh.tmdbapp.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
// using the subcomponent to inject dependencies to artist activity
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}