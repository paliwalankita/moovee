package com.ankita.tmdbclient.domain.repository

import com.ankita.tmdbclient.data.model.tvshows.TvShow

interface TvShowsRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}