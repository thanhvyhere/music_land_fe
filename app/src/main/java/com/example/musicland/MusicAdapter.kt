package com.example.musicland

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicland.R

//data class MusicList(val title: String, val artist: String)

class MusicAdapter(
    private val context: Context,
    private val list: List<MusicList>
) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.music_adapter_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val music = list[position]
//        holder.titleText.text = music.title
//        holder.artistText.text = music.artist
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val titleText: TextView = itemView.findViewById(R.id.titleText)
//        val artistText: TextView = itemView.findViewById(R.id.artistText)
    }
}
