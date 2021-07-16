package com.arsh.tmdbapp.data.repository.movie.datasourceimpl

import com.arsh.tmdbapp.data.api.TMDBService
import com.arsh.tmdbapp.data.model.movies.MovieList
import com.arsh.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}