package com.enyason.todo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enyason.todo.data.mdel.TaskEntity
import com.enyason.todo.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {


    val tasks: LiveData<List<TaskEntity>> = taskRepository.getAllTasks()

    fun saveTask(task: TaskEntity) {

        viewModelScope.launch {
            taskRepository.saveTask(task)
        }

    }

    fun updateTask(task: TaskEntity) {

        viewModelScope.launch {
            taskRepository.updateTask(task)
        }

    }

    fun deleteTask(task: TaskEntity) {
        viewModelScope.launch {
            taskRepository.deleteTask(task)
        }

    }

}