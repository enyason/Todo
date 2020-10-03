package com.enyason.todo.di

import android.content.Context
import androidx.room.Room
import com.enyason.todo.data.db.AppDataBase
import com.enyason.todo.data.repository.TaskRepository
import com.enyason.todo.data.sources.TaskRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {


    @Binds
    @Singleton
    abstract fun taskRepository(taskRepositoryImpl: TaskRepositoryImpl): TaskRepository

}


@Module
@InstallIn(ApplicationComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun roomDb(@ApplicationContext context: Context): AppDataBase {

        return Room
            .databaseBuilder(
                context,
                AppDataBase::class.java, "task_database"
            ).build()
    }
}