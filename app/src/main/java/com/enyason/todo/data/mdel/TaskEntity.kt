package com.enyason.todo.data.mdel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String
)