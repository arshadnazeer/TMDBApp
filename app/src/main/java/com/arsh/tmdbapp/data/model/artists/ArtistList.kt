package com.arsh.tmdbapp.data.model.artists
import com.arsh.tmdbapp.data.model.artists.Artist
import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val artists: List<Artist>

)