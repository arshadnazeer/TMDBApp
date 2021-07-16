package com.arsh.tmdbapp.domain.repository

import com.arsh.tmdbapp.data.model.movies.Movie

interface MovieRepository {
    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}