package com.arsh.tmdbapp.data.repository.artist.datasourceimpl

import com.arsh.tmdbapp.data.api.TMDBService
import com.arsh.tmdbapp.data.model.artists.ArtistList
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apikey: String
    ) : ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList>  = tmdbService.getPopularArtists(apikey)
}