package kz.tutorial.jsonplaceholdertypicode.presentation.posts.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment

class CommentsAdapter(private val layoutInflater: LayoutInflater, private val listener : (String) -> Unit) :
    RecyclerView.Adapter<CommentsViewHolder>() {

    private val comments: MutableList<Comment> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val view = layoutInflater.inflate(R.layout.item_comment, parent, false)

        return CommentsViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val comment = comments[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    fun setData(newData: List<Comment>) {
        notifyItemRangeRemoved(0, comments.size)
        comments.clear()
        comments.addAll(newData)
        notifyItemRangeInserted(0, comments.size)
    }
}

