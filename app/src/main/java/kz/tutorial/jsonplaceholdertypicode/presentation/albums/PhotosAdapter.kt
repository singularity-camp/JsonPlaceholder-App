package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import org.w3c.dom.Text

class PhotosAdapter(private val layoutInflater: LayoutInflater) :
    androidx.recyclerview.widget.ListAdapter<Photo, PhotosViewHolder>(DIFF_CALLBACK_PHOTO())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val view = layoutInflater.inflate(R.layout.item_photo, parent, false)

        return PhotosViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bind(photo)
    }
}

class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var tvPhotoName: TextView = itemView.findViewById(R.id.tv_photo_name)
    private var ivPhoto : ImageView = itemView.findViewById(R.id.iv_photo)

    fun bind(photo: Photo) {
        Glide.with(ivPhoto)
            .load(photo.url)
            .into(ivPhoto)


        tvPhotoName.text = photo.title
    }
}

private class DIFF_CALLBACK_PHOTO : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }

}