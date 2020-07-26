package com.enyason.todo.data.repository

import androidx.lifecycle.LiveData
import com.enyason.todo.data.mdel.TaskEntity


interface TaskRepository {

    suspend fun saveTask(taskEntity: TaskEntity)

    suspend fun updateTask(taskEntity: TaskEntity)

    suspend fun deleteTask(taskEntity: TaskEntity)

    fun getAllTasks(): LiveData<List<TaskEntity>>
}