package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album

class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val ivAlbumCover: ImageView = view.findViewById(R.id.iv_album_image)
    private val tvAlbumName: TextView = view.findViewById(R.id.tv_album_name)
    private val tvAlbumUserName: TextView = view.findViewById(R.id.tv_album_username)

    fun bind(album: Album) {
        Glide.with(ivAlbumCover).load(album.thumbnailUrl).into(ivAlbumCover)
        tvAlbumName.text = album.title
        tvAlbumUserName.text = album.username
    }
}