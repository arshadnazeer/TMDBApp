package com.arsh.tmdbapp.data.repository.artist.datasourceimpl

import com.arsh.tmdbapp.data.db.ArtistDAO
import com.arsh.tmdbapp.data.model.artists.Artist
import com.arsh.tmdbapp.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDAO: ArtistDAO) : ArtistLocalDataSource {

    override suspend fun getArtistFromFromDB(): List<Artist>  = artistDAO.getArtist()

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.saveArtist(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.deleteAllArtist()
        }
    }
}