package com.ophi.myapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ophi.myapp.databinding.ItemRowBinding

class ListAnimeAdapter(private val listAnimes: ArrayList<Anime>) : RecyclerView.Adapter<ListAnimeAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Anime)
    }

    class ListViewHolder(var binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listAnimes.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//
        val (name, synopsis, genre, release, photo) = listAnimes[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemSynopsis.text = synopsis
        holder.binding.tvItemGenre.text = genre
        holder.binding.tvItemRelease.text = release

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_anime", listAnimes[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}