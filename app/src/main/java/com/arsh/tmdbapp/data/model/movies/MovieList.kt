package com.arsh.tmdbapp.data.model.movies
import com.arsh.tmdbapp.data.model.movies.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    val movies: List<Movie>

)