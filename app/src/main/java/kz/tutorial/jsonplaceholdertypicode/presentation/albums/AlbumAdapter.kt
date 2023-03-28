package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post

class AlbumAdapter(private val layoutInflater: LayoutInflater, private val context: Context) :
    RecyclerView.Adapter<AlbumViewHolder>() {

    private val albums: MutableList<Album> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = layoutInflater.inflate(R.layout.item_album, parent, false)

        return AlbumViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(album, )
    }

    fun setData(newData: List<Album>) {
        notifyItemRangeRemoved(0, albums.size)
        albums.clear()
        albums.addAll(newData)
        notifyItemRangeInserted(0, albums.size)
    }
}

class AlbumViewHolder(itemView: View, val context: Context) : ViewHolder(itemView) {
    private var ivAlbumCover: ImageView = itemView.findViewById(R.id.iv_album_cover)
    private var tvAlbumTitle: TextView = itemView.findViewById(R.id.tv_album_name)
    private var tvUsername: TextView = itemView.findViewById(R.id.tv_username)

    fun bind(album: Album) {
        ivAlbumCover.setImageDrawable(
            AppCompatResources.getDrawable(
                context,
                R.drawable.album_default_cover
            )
        )
        tvAlbumTitle.text = album.title
        tvUsername.setText("Username")
    }
}