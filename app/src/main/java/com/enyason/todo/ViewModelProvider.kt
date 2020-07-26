package com.enyason.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.enyason.todo.data.repository.TaskRepository
import com.enyason.todo.ui.TaskViewModel

class ViewModelProvider(private val taskRepository: TaskRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val viewModel = TaskViewModel(taskRepository)
        return viewModel as T
    }
}