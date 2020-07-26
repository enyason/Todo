package com.enyason.todo.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enyason.todo.R
import com.enyason.todo.data.mdel.TaskEntity
import com.enyason.todo.data.mdel.diffUtil
import com.enyason.todo.databinding.TaskItemLayoutBinding
import com.enyason.todo.utils.inflate

class TaskAdapter : ListAdapter<TaskEntity, TaskAdapter.TaskViewHolder>(diffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = parent.inflate(R.layout.task_item_layout)
        return TaskViewHolder(TaskItemLayoutBinding.bind(view))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class TaskViewHolder(private val binding: TaskItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(taskEntity: TaskEntity) {
            binding.taskTitle.text = taskEntity.title
            binding.checkBox.isChecked = taskEntity.completed
        }
    }
}