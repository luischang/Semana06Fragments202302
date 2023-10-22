package com.example.semana06fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.semana06fragments.R
import com.example.semana06fragments.model.SongModel

class SongAdapter(private var lstSong: List<SongModel>): RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivSong: ImageView = itemView.findViewById(R.id.ivSong)
        val tvAlbum: TextView = itemView.findViewById(R.id.tvAlbum)
        val tvSong: TextView = itemView.findViewById(R.id.tvSong)
        val tvNumber: TextView = itemView.findViewById(R.id.tvNumber)
        val tvSongTime: TextView = itemView.findViewById(R.id.tvTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_musica,parent,false))
    }

    override fun onBindViewHolder(holder: SongAdapter.ViewHolder, position: Int) {
        val itemSong = lstSong[position]
        holder.tvSong.text = itemSong.songName
        holder.tvAlbum.text = itemSong.album
        holder.tvNumber.text = itemSong.numberSong
        holder.tvSongTime.text = itemSong.songTime
        holder.ivSong.setImageResource(itemSong.image)
    }

    override fun getItemCount(): Int {
        return lstSong.size
    }
}