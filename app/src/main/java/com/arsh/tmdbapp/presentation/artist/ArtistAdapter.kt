package com.arsh.tmdbapp.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arsh.tmdbapp.R
import com.arsh.tmdbapp.data.model.artists.Artist
import com.arsh.tmdbapp.data.model.movies.Movie
import com.arsh.tmdbapp.databinding.ListItemBinding
import com.bumptech.glide.Glide

class ArtistAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<Artist>()

    fun setList(artist: List<Artist>){
        artistList.clear()
        artistList.addAll(artist)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(artist:Artist){
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = artist.popularity.toString()
        // displaying movie poster
        val posterURL = "https://image.tmdb.org/t/p/w500"+artist.profilePath

        // display movie poster using Glide
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)


    }
}