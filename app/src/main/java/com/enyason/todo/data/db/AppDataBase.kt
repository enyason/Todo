package com.enyason.todo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.enyason.todo.data.mdel.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {

                val instance =
                    Room
                        .databaseBuilder(
                            context.applicationContext,
                            AppDataBase::class.java, "task_database"
                        ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}

