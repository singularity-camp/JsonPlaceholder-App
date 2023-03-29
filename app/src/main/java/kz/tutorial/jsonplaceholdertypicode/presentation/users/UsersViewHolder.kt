package kz.tutorial.jsonplaceholdertypicode.presentation.users

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.UserShort

class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvUserName: TextView = itemView.findViewById(R.id.item_user_tv_username)
    private val tvUserFullName: TextView = itemView.findViewById(R.id.item_user_tv_full_name)
    val tvUserEmail: TextView = itemView.findViewById(R.id.item_user_tv_email)

    fun bind(user: UserShort) {
        tvUserName.text = user.username
        tvUserFullName.text = user.name
        tvUserEmail.text = user.email
    }
}