package com.ankita.tmdbclient.data.api

import com.ankita.tmdbclient.data.model.artist.ArtistList
import com.ankita.tmdbclient.data.model.movies.MovieList
import com.ankita.tmdbclient.data.model.tvshows.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        api_key: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key")
        api_key: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(
        @Query("api_key")
        api_key: String): Response<ArtistList>
}