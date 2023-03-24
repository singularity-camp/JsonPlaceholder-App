package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.AlbumsWithUser

class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val ivAlbumCover: ImageView = view.findViewById(R.id.iv_album_image)
    private val tvAlbumName: TextView = view.findViewById(R.id.tv_album_name)
    private val tvAlbumUserName: TextView = view.findViewById(R.id.tv_album_username)

    fun bind(album: AlbumsWithUser) {
        //Here I planned to bind image via Glide
        // ivAlbumCover.setImageResource(album.cover)
        tvAlbumName.text = album.title
        tvAlbumUserName.text = album.userName
    }
}