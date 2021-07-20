package com.arsh.tmdbapp.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arsh.tmdbapp.R
import com.arsh.tmdbapp.data.model.movies.Movie
import com.arsh.tmdbapp.data.model.tvshows.TvShow
import com.arsh.tmdbapp.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TvAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShow: List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShow)
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
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        // displaying movie poster
        val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath

        // display movie poster using Glide
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)


    }
}