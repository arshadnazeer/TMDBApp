package com.arsh.tmdbapp.data.repository.artist.datasource

import com.arsh.tmdbapp.data.model.artists.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromFromDB() : List<Artist>
    suspend fun saveArtistToDB(artist: List<Artist>)
    suspend fun clearAll()
}