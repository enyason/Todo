package com.enyason.todo.data.sources

import androidx.lifecycle.LiveData
import com.enyason.todo.data.db.AppDataBase
import com.enyason.todo.data.model.TaskEntity

class LocalDataSource(private val db: AppDataBase) {


    suspend fun saveTask(taskEntity: TaskEntity) = db.taskDao().saveTask(taskEntity)


    suspend fun updateTask(taskEntity: TaskEntity) = db.taskDao().updateTask(taskEntity)

    suspend fun deleteTask(taskEntity: TaskEntity) = db.taskDao().deleteTask(taskEntity)

    fun getAllTasks(): LiveData<List<TaskEntity>> = db.taskDao().getTasks()

}