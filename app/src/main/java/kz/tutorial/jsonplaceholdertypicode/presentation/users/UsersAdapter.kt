package kz.tutorial.jsonplaceholdertypicode.presentation.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.User

class UsersAdapter(
    private val layoutInflater: LayoutInflater,
    private val onUserClick: (userId: Int) -> Unit,
    private val onEmailClick: (email: String) -> Unit
) : RecyclerView.Adapter<UsersViewHolder>() {

    private val users: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = layoutInflater.inflate(R.layout.item_user, parent, false)
        return UsersViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(users[position])
        holder.tvUsername.setOnClickListener { onUserClick(users[position].id) }
        holder.tvEmail.setOnClickListener { onEmailClick(users[position].email) }
    }

    fun setData(newData: List<User>) {
        users.clear()
        users.addAll(newData)
        notifyDataSetChanged()
    }
}