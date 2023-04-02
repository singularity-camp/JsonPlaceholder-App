package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album

class AlbumAdapter(private val layoutInflater: LayoutInflater,
                   private val onAlbumClick: (albumId: Int) -> Unit,
                   private val onUserClick: (userId: Int) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<Album, AlbumViewHolder>(DIFF_CALLBACK()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = layoutInflater.inflate(R.layout.item_album, parent, false)

        return AlbumViewHolder(view)
    }


    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album)

        holder.itemView.setOnClickListener{
            onAlbumClick(album.id)
        }

        holder.tvUsername.setOnClickListener {
            onUserClick(album.userId)
        }
    }
}

class AlbumViewHolder(itemView: View) : ViewHolder(itemView) {
    private var ivAlbumCover: ImageView = itemView.findViewById(R.id.iv_album_cover)
    private var tvAlbumTitle: TextView = itemView.findViewById(R.id.tv_album_name)
    var tvUsername: TextView = itemView.findViewById(R.id.tv_username)

    fun bind(album: Album) {
        Glide.with(ivAlbumCover)
            .load(album.previewPhoto)
            .into(ivAlbumCover)

        tvAlbumTitle.text = album.title
        tvUsername.text = album.username
    }
}

private class DIFF_CALLBACK : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }

}