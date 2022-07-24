package com.example.todoapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.R
import com.example.todoapp.model.Todo
import com.example.todoapp.model.TodoDatabase
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        if (todoText.text.isEmpty()) {
            saveActionButton.setOnClickListener {
                GlobalScope.launch {


                    var todo = todoText.text.toString().trim()
                    val todoItem = Todo(todo)
                    TodoDatabase(applicationContext).getTodoDao().addTodo(todoItem)

                    val intent = Intent(this@AddActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}