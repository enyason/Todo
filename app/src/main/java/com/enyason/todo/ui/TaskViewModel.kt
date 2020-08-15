package com.enyason.todo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enyason.todo.data.model.TaskEntity
import com.enyason.todo.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {


    val tasks: LiveData<List<TaskEntity>> = taskRepository.getAllTasks()

    val progress = Transformations.map(taskRepository.getAllTasks()) { items ->
        var count = 0

        items.map { task ->
            if (task.completed) {
                count += 1
            }
        }


        val progress = if (items.isEmpty()) {
            0
        } else {
            count / items.size
        }

        progress
    }

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