package com.enyason.todo.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.enyason.todo.data.mdel.TaskEntity

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTask(entity: TaskEntity)

    @Update
    suspend fun updateTask(entity: TaskEntity)

//    @Query("DELETE * FROM task_table WHERE id : = id")
    @Delete
    suspend fun deleteTask(entity: TaskEntity)

    @Query("SELECT * FROM task_table")
    fun getTasks(): LiveData<List<TaskEntity>>

}