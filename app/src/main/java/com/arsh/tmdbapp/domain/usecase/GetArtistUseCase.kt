package com.arsh.tmdbapp.domain.usecase

import com.arsh.tmdbapp.data.model.artists.Artist
import com.arsh.tmdbapp.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtist()
}