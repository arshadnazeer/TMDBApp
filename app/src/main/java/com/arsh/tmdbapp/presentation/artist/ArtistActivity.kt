package com.arsh.tmdbapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.arsh.tmdbapp.R
import com.arsh.tmdbapp.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {
    private lateinit var artistBinding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        artistBinding = DataBindingUtil.setContentView(this,R.layout.activity_artist)
    }
}