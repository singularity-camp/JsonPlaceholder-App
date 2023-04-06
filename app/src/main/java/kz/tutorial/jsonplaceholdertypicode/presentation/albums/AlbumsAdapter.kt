package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Album

class AlbumsAdapter(
    private val layoutInflater: LayoutInflater,
    private val onAlbumClick: (albumId: Int) -> Unit,
    private val onUserClick: (userId: Int) -> Unit,
) : androidx.recyclerview.widget.ListAdapter<Album, AlbumsViewHolder>(DIFF_CALLBACK_ALBUM()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val view = layoutInflater.inflate(R.layout.item_album, parent, false)
        return AlbumsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album)
        holder.tvAlbumName.setOnClickListener { onAlbumClick(album.id) }
        holder.tvUsername.setOnClickListener { onUserClick(album.userId) }
    }
}

private class DIFF_CALLBACK_ALBUM : ItemCallback<Album>() {
    override fun areItemsTheSame(old: Album, new: Album): Boolean {
        return old.id == new.id
    }

    override fun areContentsTheSame(old: Album, new: Album): Boolean {
        return old == new
    }

}