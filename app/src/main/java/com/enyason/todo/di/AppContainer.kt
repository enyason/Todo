package com.enyason.todo.di

import android.content.Context
import com.enyason.todo.data.db.AppDataBase
import com.enyason.todo.data.repository.TaskRepository
import com.enyason.todo.data.sources.LocalDataSource
import com.enyason.todo.data.sources.TaskRepositoryImpl

class AppContainer(private val context: Context) {

    private val database by lazy {
        AppDataBase.getDatabase(context)
    }

    private val localDataSource by lazy {
        LocalDataSource(database)
    }

    val taskRepository: TaskRepository by lazy {
        TaskRepositoryImpl(localDataSource)
    }

}