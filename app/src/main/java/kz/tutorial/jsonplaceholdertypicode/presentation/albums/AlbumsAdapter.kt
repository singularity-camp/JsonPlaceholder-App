package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.AlbumsWithUser
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener

class AlbumsAdapter(private val layoutInflater: LayoutInflater) :
    RecyclerView.Adapter<AlbumViewHolder>() {
    private val albums: MutableList<AlbumsWithUser> = mutableListOf()
    var listener: ClickListener<AlbumsWithUser>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = layoutInflater.inflate(R.layout.item_album, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(album)
        holder.itemView.setOnClickListener {
            listener?.onClick(album)
        }
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    fun setData(newData: List<AlbumsWithUser>) {
        notifyItemRangeRemoved(0, albums.size)
        albums.clear()
        albums.addAll(newData)
        notifyItemRangeInserted(0, albums.size)
    }

}