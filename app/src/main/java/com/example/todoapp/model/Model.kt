package com.example.todoapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Todo(
    val content: String,

    @PrimaryKey(autoGenerate = true)
    var id : Int? =null
)