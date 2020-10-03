package com.enyason.todo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.enyason.todo.data.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}

