package com.example.musicland

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.Manifest
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.view.View
import android.widget.Toast


class MainActivity : ComponentActivity() {
    val musicLists = ArrayList<MusicList>()
    lateinit var musicRecyclerView: RecyclerView
    val isPlaying = false
    val musicFile = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val decorView = window.decorView
        val options = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        decorView.setSystemUiVisibility(options)
        setContentView(R.layout.activity_homepage)
        val searchBtn = findViewById<LinearLayout>(R.id.searchBtn)
        val menuBtn = findViewById<LinearLayout>(R.id.menuBtn)
        musicRecyclerView = findViewById<RecyclerView>(R.id.musicRecyclerView)
        val bottomBar = findViewById<LinearLayout>(R.id.bottomBar)
        val previousBtn = findViewById<ImageView>(R.id.previousBtn)
        val playPauseCard = findViewById<CardView>(R.id.playPauseCard)
        val playPauseImg = findViewById<ImageView>(R.id.playPauseImg)
        val nextBtn = findViewById<ImageView>(R.id.nextBtn)

        musicRecyclerView.setHasFixedSize(true);
        musicRecyclerView.layoutManager = LinearLayoutManager(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            // Android 13+ (API 33+): Dùng READ_MEDIA_AUDIO
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                getMusicFile()
            } else {
                requestPermissions(arrayOf(Manifest.permission.READ_MEDIA_AUDIO), 1)
            }
        } else {
            // Android <= 12 (API 32): Dùng READ_EXTERNAL_STORAGE
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                getMusicFile()
            } else {
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
            }
        }



    }
    private fun getMusicFile() {
        val contentResolver = contentResolver
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
//        val selection = "${MediaStore.Audio.Media.DISPLAY_NAME} LIKE ?"
//        val selectionArgs = arrayOf("%.mp3")

        val cursor = contentResolver.query(
            uri,
            null,MediaStore.Audio.Media.DATA + " like ?",
            arrayOf("%.mp3"),
            null
        )
        if(cursor == null)
        {
            Toast.makeText(this, "Something went wrong!!", Toast.LENGTH_SHORT).show()
        }
        else if(!cursor.moveToNext())
            {
            Toast.makeText(this, "No music file found!!", Toast.LENGTH_SHORT).show()

        }else
        {
            val titleIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            while (cursor.moveToNext()) {
                val getMusicFileName = cursor.getString(titleIndex)
                val getArtistName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST))
                val cursorId = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID))

                val musicUri = Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, cursorId.toString())
                var getDuration = "00:00"
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
                    getDuration = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION))
                }

                val musicList = MusicList(getMusicFileName, getArtistName, getDuration, false, musicUri)
                musicLists.add(musicList)

                Toast.makeText(this, "Music file found!!", Toast.LENGTH_SHORT).show()
            }
            musicRecyclerView.setAdapter(MusicAdapter(musicLists, this))
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
        deviceId: Int
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getMusicFile()
        } else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if(hasFocus)
        {
            val decorView = window.decorView
            val options = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            decorView.setSystemUiVisibility(options)

        }
    }
}



