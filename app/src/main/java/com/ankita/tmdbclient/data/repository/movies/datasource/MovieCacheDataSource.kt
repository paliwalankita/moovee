package com.ankita.tmdbclient.data.repository.movies.datasource

import com.ankita.tmdbclient.data.model.movies.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}