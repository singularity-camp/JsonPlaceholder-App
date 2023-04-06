package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo

class AlbumPhotosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val ivAlbumPhoto: ImageView = view.findViewById(R.id.iv_album_photo)
    private val tvAlbumPhotoName: TextView = view.findViewById(R.id.tv_photo_name)

    fun bind(photo: Photo) {
        Glide.with(ivAlbumPhoto).load(photo.url).into(ivAlbumPhoto)
        tvAlbumPhotoName.text = photo.title
    }
}