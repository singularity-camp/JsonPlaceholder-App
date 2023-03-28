package kz.tutorial.jsonplaceholdertypicode.presentation.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.UserShort
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener

class UsersAdapter(
    private val layoutInflater: LayoutInflater,
    private val onEmailClick: (String) -> Unit,
) : ListAdapter<UserShort, UsersViewHolder>(DiffCallback()) {

    var onItemClicked: ClickListener<UserShort>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_user, parent, false)
        return UsersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
        holder.itemView.setOnClickListener {
            onItemClicked?.onClick(user)
        }
        holder.tvUserEmail.setOnClickListener { onEmailClick(user.email) }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<UserShort>() {
    override fun areItemsTheSame(oldItem: UserShort, newItem: UserShort): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserShort, newItem: UserShort): Boolean {
        return oldItem == newItem
    }
}