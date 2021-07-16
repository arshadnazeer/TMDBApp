package com.arsh.tmdbapp.presentation.di.core

import com.arsh.tmdbapp.domain.repository.ArtistRepository
import com.arsh.tmdbapp.domain.repository.MovieRepository
import com.arsh.tmdbapp.domain.repository.TvShowRepository
import com.arsh.tmdbapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

// ViewModel factories needs these use cases as dependencies
@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }


    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }


    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }
}