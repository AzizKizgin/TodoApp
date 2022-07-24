package com.example.todoapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.Adapter.TodoAdapter
import com.example.todoapp.R
import com.example.todoapp.model.Todo
import com.example.todoapp.model.TodoDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo.*
import kotlinx.android.synthetic.main.item_todo.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.NonCancellable.start
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(){

    lateinit var adapter: TodoAdapter
    lateinit var todoList : Array<Todo>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addActionButton.setOnClickListener {
            val intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
        }



        adapter = TodoAdapter(arrayListOf())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        GlobalScope.launch {
            val todoList = TodoDatabase(this@MainActivity.applicationContext).getTodoDao().getAllTodos()
            adapter.updateList(todoList)

        }


    }
/*
    fun deleteItem(view: View){

            GlobalScope.launch {

                val currentItem = todoItem.text.toString()
                TodoDatabase(view.context).getTodoDao().deleteTodo(currentItem)

                val todoList = TodoDatabase(view.context).getTodoDao().getAllTodos()

                adapter.updateList(todoList)
                start()
            }

    }
*/
}