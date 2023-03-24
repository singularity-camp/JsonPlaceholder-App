package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo

class PhotosAdapter(private val layoutInflater: LayoutInflater) :
    RecyclerView.Adapter<PhotosViewHolder>() {
    private val photos: MutableList<Photo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val view = layoutInflater.inflate(R.layout.item_photo, parent, false)
        return PhotosViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun setData(newData: List<Photo>) {
        notifyItemRangeRemoved(0, photos.size)
        photos.clear()
        photos.addAll(newData)
        notifyItemRangeInserted(0, photos.size)
    }

}