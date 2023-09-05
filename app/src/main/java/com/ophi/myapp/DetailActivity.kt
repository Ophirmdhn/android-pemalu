package com.ophi.myapp


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi

class DetailActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataAnime = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Anime>("key_anime", Anime::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Anime>("key_anime")
        }

        val imgDetailPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvSynopsis: TextView = findViewById(R.id.tv_synopsis)
        val tvDetailGenre: TextView = findViewById(R.id.tv_detail_genre)
        val tvDetailRelease: TextView = findViewById(R.id.tv_detail_release)

        if (dataAnime != null) {
            imgDetailPhoto.setImageResource(dataAnime.photo)
            tvDetailName.text = dataAnime.name
            tvSynopsis.text = dataAnime.synopsis
            tvDetailGenre.text = dataAnime.genre
            tvDetailRelease.text = dataAnime.release
        }

    }
}