package kz.tutorial.jsonplaceholdertypicode.presentation.users.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo

class ToDoAdapter(private val layoutInflater: LayoutInflater) :
    RecyclerView.Adapter<ToDoViewHolder>() {

    private val todos: MutableList<ToDo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = layoutInflater.inflate(R.layout.item_task, parent, false)
        return ToDoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val todo = todos[position]
        holder.bind(todo)
    }

    fun setData(newData: List<ToDo>) {
        todos.clear()
        todos.addAll(newData)
        notifyDataSetChanged()
    }
}