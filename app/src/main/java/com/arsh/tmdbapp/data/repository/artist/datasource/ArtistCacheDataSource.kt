package com.arsh.tmdbapp.data.repository.artist.datasource

import com.arsh.tmdbapp.data.model.artists.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artist: List<Artist>)
}