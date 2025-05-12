package com.example.musicland
import com.example.musicland.R
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class DetailViewActivity : AppCompatActivity() {

    // Khai báo các view trong layout
    private lateinit var songTitleTextView: TextView
    private lateinit var artistNameTextView: TextView
    private lateinit var lyricsTextView: TextView
    private lateinit var songImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_music)

        val songTitleTextView : TextView = findViewById(R.id.songTitleText)
        val artistNameTextView : TextView = findViewById(R.id.artistNameText)
        val lyricsTextView : TextView = findViewById(R.id.lyricsText)
        val songImageView : ImageView = findViewById(R.id.songImage)

        songTitleTextView.text = "Tên bài hát"
        artistNameTextView.text = "Tên nghệ sĩ"

        // Lời bài hát
        val rawLyrics = """
            oh lost lost in the words that we scream
            I don't even wanna do this anymore
            'cause you already know
            What you mean to me
            And our love's the only one worth fighting for
            Wherever you go that's where I'll follow
            Nobody's promised tomorrow
            So I'ma love you every night like
            It's the last night
            Like it's the last night
            If the world was ending
            I'd wanna be next to you
            If the party was over
            And our time on Earth was through
            I'd wanna hold you just for a while
            And die with a smile
            If the world was ending
            I'd wanna be next to you
        """

        val formattedLyrics = formatLyrics(rawLyrics)

        lyricsTextView.text = formattedLyrics

    }

    // Hàm ngắt dòng lyrics sau mỗi 50 ký tự
    private fun formatLyrics(lyrics: String): String {
        val maxLineLength = 50 // Số ký tự tối đa trên mỗi dòng
        val words = lyrics.split(" ") // Tách tất cả các từ
        val formattedLyrics = StringBuilder()
        var currentLine = StringBuilder()

        for (word in words) {
            if (currentLine.length + word.length + 1 > maxLineLength) {
                formattedLyrics.append(currentLine.toString()).append("\n") // Thêm dấu ngắt dòng
                currentLine = StringBuilder() // Reset current line
            }
            if (currentLine.isNotEmpty()) {
                currentLine.append(" ") // Thêm dấu cách giữa các từ
            }
            currentLine.append(word) // Thêm từ vào dòng hiện tại
        }
        // Thêm dòng cuối cùng nếu còn từ nào
        if (currentLine.isNotEmpty()) {
            formattedLyrics.append(currentLine.toString())
        }

        return formattedLyrics.toString()
    }
}
