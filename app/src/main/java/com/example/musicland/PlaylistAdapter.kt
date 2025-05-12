import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicland.R

data class Playlist(
    val playlistId: Int,
    val title: String,
    val urlImage: String,
    val subtitle: String
)

class PlaylistAdapter(
    private val playlistList: List<Playlist>,
    private val onItemClick: (Playlist) -> Unit
) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    inner class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.itemImage)
        private val titleTextView: TextView = itemView.findViewById(R.id.itemTitle)
        private val subtitleTextView: TextView = itemView.findViewById(R.id.itemSubtitle)

        fun bind(playlist: Playlist) {
            titleTextView.text = playlist.title
            subtitleTextView.text = playlist.subtitle

            // Load ảnh bằng Glide (nếu có url ảnh)
            Glide.with(itemView.context)
                .load(playlist.urlImage)
                .placeholder(R.drawable.sample_image) // ảnh tạm nếu url lỗi
                .into(imageView)

            // Set click event
            itemView.setOnClickListener {
                onItemClick(playlist)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_playlist, parent, false)
        return PlaylistViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(playlistList[position])
    }

    override fun getItemCount(): Int = playlistList.size
}
