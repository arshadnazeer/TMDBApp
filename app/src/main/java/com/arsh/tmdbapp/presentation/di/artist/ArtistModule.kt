package com.arsh.tmdbapp.presentation.di.artist

import com.arsh.tmdbapp.domain.usecase.GetArtistUseCase
import com.arsh.tmdbapp.domain.usecase.UpdateArtistUseCase
import com.arsh.tmdbapp.presentation.artist.ArtistViewModel
import com.arsh.tmdbapp.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule() {
    @ArtistScope
    @Provides
    fun providesArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase,updateArtistUseCase)
    }
}