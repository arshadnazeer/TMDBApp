package com.arsh.tmdbapp.presentation.di.artist

import com.arsh.tmdbapp.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
// using the subcomponent to inject dependencies to artist activity
interface ArtistSubComponent {
    fun inject(artistActivity : ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}