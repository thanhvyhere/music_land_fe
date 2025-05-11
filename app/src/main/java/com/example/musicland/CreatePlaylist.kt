package com.example.musicland

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.musicland.R

class CreatePlaylist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_playlist) // kết nối với layout XML bạn đã tạo

        // Ánh xạ view từ XML
        val createBtn: Button = findViewById(R.id.createPlaylistBtn)
        val nameInput: EditText = findViewById(R.id.playlistNameInput)
        val descriptionInput: EditText = findViewById(R.id.playlistDescriptionInput)

        // Xử lý khi nhấn nút "Create Playlist"
        createBtn.setOnClickListener {
            val playlistName = nameInput.text.toString().trim()

            if (playlistName.isEmpty()) {
                Toast.makeText(this, "Playlist name cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Lưu playlist vào cơ sở dữ liệu hoặc danh sách
                Toast.makeText(this, "Playlist '$playlistName' created!", Toast.LENGTH_SHORT).show()
                finish() // hoặc chuyển sang Activity khác
            }
        }
    }
}
