package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.Post
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener

class CommentsAdapter(private val layoutInflater: LayoutInflater) :
    RecyclerView.Adapter<CommentsViewHolder>() {

    private val comments: MutableList<Comment> = mutableListOf()
    var listener: ClickListener<Comment>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val view = layoutInflater.inflate(R.layout.item_comment, parent, false)

        return CommentsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(comments.size > 5)
            5
        else
            comments.size
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val comment = comments[position]
        holder.bind(comment)
        holder.itemView.setOnClickListener {
            listener?.onClick(comment)
        }
    }

    fun setData(newData: List<Comment>) {
        notifyItemRangeRemoved(0, comments.size)
        comments.clear()
        comments.addAll(newData)
        notifyItemRangeInserted(0, comments.size)
    }
}

class CommentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var tvCommentName: TextView = itemView.findViewById(R.id.tv_comment_name)
    private var tvEmail: TextView = itemView.findViewById(R.id.tv_email)
    private var tvBody: TextView = itemView.findViewById(R.id.tv_body)

    fun bind(comment: Comment) {
        tvCommentName.text = comment.name
        tvEmail.text = comment.email
        tvBody.text = comment.body
    }
}