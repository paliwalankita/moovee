package com.ankita.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ankita.tmdbclient.domain.usecase.GetArtistUseCase
import com.ankita.tmdbclient.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModel() {
    fun getArtist() = liveData{
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData{
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }
}