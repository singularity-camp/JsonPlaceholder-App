package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.AlbumsWithUser
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo

class PhotosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val ivPhoto: ImageView = view.findViewById(R.id.iv_photo_image)
    private val tvPhotoName: TextView = view.findViewById(R.id.tv_photo_name)

    fun bind(photo: Photo) {
        //Here I planned to bind image via Glide
        // ivPhoto.setImageResource(photo.url)
        tvPhotoName.text = photo.title
    }
}