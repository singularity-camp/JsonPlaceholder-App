package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo

class AlbumPhotosAdapter(private val layoutInflater: LayoutInflater) :
    RecyclerView.Adapter<AlbumPhotosViewHolder>() {

    private val photos: MutableList<Photo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumPhotosViewHolder {
        val view = layoutInflater.inflate(R.layout.item_photo, parent, false)
        return AlbumPhotosViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumPhotosViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int = photos.size

    fun setData(newData: List<Photo>) {
        photos.clear()
        photos.addAll(newData)
        notifyDataSetChanged()
    }
}