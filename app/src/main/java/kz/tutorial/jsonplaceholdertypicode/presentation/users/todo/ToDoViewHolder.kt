package kz.tutorial.jsonplaceholdertypicode.presentation.users.todo

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo

class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvTaskName: TextView = itemView.findViewById(R.id.tv_task_name)
    private val cbTask: CheckBox = itemView.findViewById(R.id.cb_task)

    fun bind(todo: ToDo) {
        tvTaskName.text = todo.title
        cbTask.isChecked = todo.completed
    }

}
