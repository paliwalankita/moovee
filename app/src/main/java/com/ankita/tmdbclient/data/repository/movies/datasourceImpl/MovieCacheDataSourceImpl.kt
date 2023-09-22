package com.ankita.tmdbclient.data.repository.movies.datasourceImpl

import com.ankita.tmdbclient.data.model.movies.Movie
import com.ankita.tmdbclient.data.repository.movies.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl() : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}

