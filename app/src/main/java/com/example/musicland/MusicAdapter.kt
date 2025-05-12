package com.example.musicland

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale
import java.util.concurrent.TimeUnit

class MusicAdapter(
    private val list: List<MusicList>,
    private val context: Context,
    private var playingPosition: Int = 0

) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    // ViewHolder inner class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rootLayout: View = itemView.findViewById(R.id.rootLayout)
        val musicArtist: TextView = itemView.findViewById(R.id.musicArtist)
        val musicTitle: TextView = itemView.findViewById(R.id.musicTitle)
        val musicDuration: TextView = itemView.findViewById(R.id.musicDuration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_adapter_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        // Bind your data to the views here
        val list2: MusicList = list[position]

        if(list2.isPlaying)
        {
            playingPosition = position
            holder.rootLayout.setBackgroundResource(R.drawable.round_back_blue_10)
        }
        else{
            holder.rootLayout.setBackgroundResource(R.drawable.round_back_10)
        }
        val generateDuration = String.format(
            Locale.getDefault(),"%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(list2.duration.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(list2.duration.toLong()),
            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(list2.duration.toLong())))
        holder.musicTitle.setText(list2.title)
        holder.musicArtist.setText(list2.artist)
        holder.musicDuration.setText(generateDuration)

        holder.rootLayout.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                list[playingPosition].isPlaying = false
                list[position].isPlaying = true
                notifyDataSetChanged()
            }
        })
    }

    override fun getItemCount(): Int = list.size
}

