package kz.tutorial.jsonplaceholdertypicode.presentation.comments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.Comment
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener

class CommentAdapter(private val inflater: LayoutInflater) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    private var comments: List<Comment> = emptyList()

    var listener: ClickListener<Comment>? = null

    fun setData(comments: List<Comment>) {
        this.comments = comments
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val itemView = inflater.inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int {
        return if (comments.size > 5) 5 else comments.size
    }

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvName: TextView = itemView.findViewById(R.id.tv_comment_title)
        private val tvEmail: TextView = itemView.findViewById(R.id.tv_email)
        private val tvBody: TextView = itemView.findViewById(R.id.tv_comment_body)

        fun bind(comment: Comment) {
            tvName.text = comment.name
            tvBody.text = comment.body
            tvEmail.text = comment.email

            itemView.setOnClickListener {
                listener?.onClick(comment)
            }
        }
    }
}