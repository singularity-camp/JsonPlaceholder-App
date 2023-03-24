package kz.tutorial.jsonplaceholdertypicode.presentation.posts.comments

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment

class CommentsViewHolder(itemView: View, private val listener: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private var tvCommentName: TextView = itemView.findViewById(R.id.tv_comment_name)
    private var tvCommentEmail: TextView = itemView.findViewById(R.id.tv_comment_email)
    private var tvCommentBody: TextView = itemView.findViewById(R.id.tv_comment_body)

    fun bind(comment: Comment) {
        tvCommentName.text = comment.name
        tvCommentEmail.text = comment.email
        tvCommentBody.text = comment.body

        tvCommentEmail.setOnClickListener {
            listener(comment.email)
        }
    }
}