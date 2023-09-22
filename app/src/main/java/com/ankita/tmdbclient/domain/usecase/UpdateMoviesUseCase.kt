package com.ankita.tmdbclient.domain.usecase

import com.ankita.tmdbclient.data.model.movies.Movie
import com.ankita.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}