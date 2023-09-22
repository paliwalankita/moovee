package com.ankita.tmdbclient.data.repository.movies.datasource

import com.ankita.tmdbclient.data.model.movies.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}