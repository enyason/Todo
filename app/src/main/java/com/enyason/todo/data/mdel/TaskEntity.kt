package com.enyason.todo.data.mdel

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "task_table")
data class TaskEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val completed: Boolean,
    val timeCreated: Long
)


val diffUtil = object : DiffUtil.ItemCallback<TaskEntity>() {
    override fun areItemsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
        return oldItem == newItem
    }

}