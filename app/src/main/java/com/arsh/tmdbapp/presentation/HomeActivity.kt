package com.arsh.tmdbapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.arsh.tmdbapp.R
import com.arsh.tmdbapp.databinding.ActivityHomeBinding
import com.arsh.tmdbapp.presentation.artist.ArtistActivity
import com.arsh.tmdbapp.presentation.movie.MovieActivity
import com.arsh.tmdbapp.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        homeBinding.movieButton.setOnClickListener {
            val intent = Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }

        homeBinding.tvButton.setOnClickListener {
            val intent = Intent(this,TvShowActivity::class.java)
            startActivity(intent)
        }

        homeBinding.artistsButton.setOnClickListener {
            val intent = Intent(this,ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}