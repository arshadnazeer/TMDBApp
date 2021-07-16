package com.arsh.tmdbapp.domain.usecase

import com.arsh.tmdbapp.data.model.tvshows.TvShow
import com.arsh.tmdbapp.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()
}