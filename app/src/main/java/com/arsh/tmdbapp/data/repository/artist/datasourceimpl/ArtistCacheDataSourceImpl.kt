package com.arsh.tmdbapp.data.repository.artist.datasourceimpl

import com.arsh.tmdbapp.data.model.artists.Artist
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}