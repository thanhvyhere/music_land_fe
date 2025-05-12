package com.example.musicland

import android.net.Uri

data class MusicList(
    val title: String,
    val artist: String,
    val duration: String,
    var isPlaying: Boolean,
    val musicUri: Uri
)
