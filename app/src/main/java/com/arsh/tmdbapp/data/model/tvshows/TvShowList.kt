package com.arsh.tmdbapp.data.model.tvshows


import com.arsh.tmdbapp.data.model.tvshows.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>

)