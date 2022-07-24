package com.example.todoapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TodoDao {

    @Insert
    suspend fun addTodo(vararg todo: Todo)

    @Query("Select * from todo")
    suspend fun getAllTodos(): Array<Todo>

    @Query("Delete from todo where content == :content")
    suspend fun deleteTodo(content:String)

}