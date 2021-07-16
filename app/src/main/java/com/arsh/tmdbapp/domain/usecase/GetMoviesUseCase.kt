package com.arsh.tmdbapp.domain.usecase

import com.arsh.tmdbapp.data.model.movies.Movie
import com.arsh.tmdbapp.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun exexute() : List<Movie>? = movieRepository.getMovies()
}