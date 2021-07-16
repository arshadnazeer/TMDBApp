package com.arsh.tmdbapp.domain.usecase

import com.arsh.tmdbapp.data.model.artists.Artist
import com.arsh.tmdbapp.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtist()
}