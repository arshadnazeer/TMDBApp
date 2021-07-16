package com.arsh.tmdbapp.data.repository.artist.datasource

import com.arsh.tmdbapp.data.model.artists.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist():Response<ArtistList>
}