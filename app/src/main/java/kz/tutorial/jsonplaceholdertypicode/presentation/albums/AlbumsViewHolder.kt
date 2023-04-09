package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album

class AlbumsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val ivAlbum: ImageView = itemView.findViewById(R.id.iv_album)
    val tvAlbumName: TextView = itemView.findViewById(R.id.tv_album_name)
    val tvUsername: TextView = itemView.findViewById(R.id.tv_username)

    fun bind(album: Album) {
        tvAlbumName.text = album.title
        tvUsername.text = album.username

        Glide.with(ivAlbum).load(album.previewPhoto).into(ivAlbum)
    }
}