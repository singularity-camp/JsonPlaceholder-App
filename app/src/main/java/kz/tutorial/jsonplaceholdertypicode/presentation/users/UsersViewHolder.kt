package kz.tutorial.jsonplaceholdertypicode.presentation.users

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.User

class UsersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvUsername: TextView = itemView.findViewById(R.id.tv_username)
    val tvFullname: TextView = itemView.findViewById(R.id.tv_fullname)
    val tvEmail: TextView = itemView.findViewById(R.id.tv_email)

    fun bind(user: User) {
        tvUsername.text = user.username
        tvFullname.text = user.name
        tvEmail.text = user.email
    }
}