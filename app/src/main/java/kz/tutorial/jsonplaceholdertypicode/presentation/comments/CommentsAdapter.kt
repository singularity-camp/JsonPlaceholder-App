package kz.tutorial.jsonplaceholdertypicode.presentation.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment

class CommentsAdapter(
    private val layoutInflater: LayoutInflater,
    private val onEmailClick: (String) -> Unit,
) : androidx.recyclerview.widget.ListAdapter<Comment, CommentViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = layoutInflater.inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = getItem(position)
        holder.bind(comment)

        //Можно перенести внуть вьюхолдера. Не принципиально
        holder.tvEmail.setOnClickListener { onEmailClick(comment.email) }
    }
}

// Это нас избавит от нужды делать самим notifyItemChanged, notifyDataSetChanged итд
private class DiffCallback : DiffUtil.ItemCallback<Comment>() {
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        //Проверяет каждое поле в объекте. Тем самым поменялся ли конкретный элемент
        return oldItem == newItem
    }
}