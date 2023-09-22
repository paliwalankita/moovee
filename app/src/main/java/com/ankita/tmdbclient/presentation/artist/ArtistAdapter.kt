package com.ankita.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ankita.tmdbclient.R
import com.ankita.tmdbclient.data.model.artist.Artist
import com.ankita.tmdbclient.data.model.artist.ArtistList
import com.ankita.tmdbclient.databinding.ListItemBinding
import com.ankita.tmdbclient.presentation.movie.MovieViewHolder
import com.bumptech.glide.Glide

class ArtistAdapter: RecyclerView.Adapter<ArtistViewHolder>() {
    private val artistList = ArrayList<Artist>()
    fun setList(artists: List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.list_item,
            parent,
            false)

        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
       return artistList.size
    }
}

class ArtistViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(artist: Artist){
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = artist.popularity.toString()
        val posterURL = "https://image.tmdb.org/t/p/w500"+artist.profilePath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }

}