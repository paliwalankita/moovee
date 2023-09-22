package com.ankita.tmdbclient.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ankita.tmdbclient.domain.usecase.GetArtistUseCase
import com.ankita.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.ankita.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.ankita.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {
    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}