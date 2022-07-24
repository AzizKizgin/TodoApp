package com.example.todoapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.model.Todo
import com.example.todoapp.model.TodoDatabase
import kotlinx.android.synthetic.main.item_todo.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TodoAdapter(val todoList: ArrayList<Todo>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    inner class TodoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.todoItem.text = todoList[position].content

        holder.itemView.imageView.setOnClickListener{
            GlobalScope.launch {
                TodoDatabase(it.context).getTodoDao()
                    .deleteTodo(holder.itemView.todoItem.text.toString())

            }.also {
                todoList.removeAt(position)
                notifyDataSetChanged()
            }

        }

    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun updateList(newList: Array<Todo>){
        todoList.clear()
        todoList.addAll(newList)
        notifyDataSetChanged()
    }
}