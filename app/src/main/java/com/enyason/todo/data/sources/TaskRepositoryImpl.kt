package com.enyason.todo.data.sources

import androidx.lifecycle.LiveData
import com.enyason.todo.data.mdel.TaskEntity
import com.enyason.todo.data.repository.TaskRepository

class TaskRepositoryImpl(private val localDataSource: LocalDataSource) : TaskRepository {
    override suspend fun saveTask(taskEntity: TaskEntity) {
        localDataSource.saveTask(taskEntity)
    }

    override suspend fun updateTask(taskEntity: TaskEntity) {
        localDataSource.updateTask(taskEntity)
    }

    override fun getAllTasks(): LiveData<List<TaskEntity>> {
        return localDataSource.getAllTasks()
    }
}