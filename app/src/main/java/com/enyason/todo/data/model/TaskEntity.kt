package com.enyason.todo.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "task_table")
@Parcelize
data class TaskEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val completed: Boolean,
    val timeCreated: Long
) : Parcelable


val diffUtil = object : DiffUtil.ItemCallback<TaskEntity>() {
    override fun areItemsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
        return oldItem == newItem
    }

}