package com.arsh.tmdbapp.domain.repository

import com.arsh.tmdbapp.data.model.artists.Artist

interface ArtistRepository {
    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?
}