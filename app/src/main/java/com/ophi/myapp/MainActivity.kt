package com.ophi.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.ophi.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            binding.rvAnime.setHasFixedSize(true)
        }

        showRecyclerList()

    }

    private val listAnimes: ArrayList<Anime>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataSynopsis = resources.getStringArray(R.array.data_synopsis)
            val dataGenre = resources.getStringArray(R.array.data_genre)
            val dataRelease = resources.getStringArray(R.array.data_release)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listAnimes = ArrayList<Anime>()

            for (i in dataName.indices) {
                val anime = Anime(dataName[i], dataSynopsis[i], dataGenre[i], dataRelease[i], dataPhoto.getResourceId(i, -1))
                listAnimes.add(anime)
            }
            return listAnimes
        }

    private fun showRecyclerList() {
        binding.rvAnime.layoutManager = LinearLayoutManager(this)
        val listAnimeAdapter = ListAnimeAdapter(listAnimes = listAnimes)
        binding.rvAnime.adapter = listAnimeAdapter

        listAnimeAdapter.setOnItemClickCallback(object : ListAnimeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Anime) {

            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about_page -> {
                val moveActivity = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveActivity)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}