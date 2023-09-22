package com.ankita.tmdbclient.domain.usecase

import com.ankita.tmdbclient.data.model.tvshows.TvShow
import com.ankita.tmdbclient.domain.repository.TvShowsRepository

class GetTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute(): List<TvShow>? = tvShowsRepository.getTvShows()
}