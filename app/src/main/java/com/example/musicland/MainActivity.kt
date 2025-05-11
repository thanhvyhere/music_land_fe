package com.example.musicland

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicland.R
import com.example.musicland.ui.theme.MusicLandTheme

import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchBtn: LinearLayout = findViewById(R.id.searchBtn);
        val menuBtn: LinearLayout = findViewById(R.id.menuBtn);
        val musicRecyclerView: RecyclerView = findViewById(R.id.musicRecyclerView);
        val playPauseCard: CardView = findViewById(R.id.playPauseCard);
        val playPauseImg: ImageView = findViewById(R.id.playPauseImg);
        val previousBtn: ImageView = findViewById(R.id.previousBtn);
        val nextBtn: ImageView = findViewById(R.id.nextBtn);


        musicRecyclerView.setHasFixedSize(true);
        musicRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}

