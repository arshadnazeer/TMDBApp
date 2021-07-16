package com.arsh.tmdbapp.data.repository.movie.datasource

import com.arsh.tmdbapp.data.model.movies.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}