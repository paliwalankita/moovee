package com.ankita.tmdbclient.domain.usecase

import com.ankita.tmdbclient.data.model.artist.Artist
import com.ankita.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtist()
}