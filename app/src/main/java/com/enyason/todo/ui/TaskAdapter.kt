package com.enyason.todo.ui

import android.graphics.Paint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enyason.todo.R
import com.enyason.todo.data.model.TaskEntity
import com.enyason.todo.data.model.diffUtil
import com.enyason.todo.databinding.TaskItemLayoutBinding
import com.enyason.todo.utils.inflate

class TaskAdapter(
    private val moreClick: (TaskEntity,View) -> Unit
) :
    ListAdapter<TaskEntity, TaskAdapter.TaskViewHolder>(diffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = parent.inflate(R.layout.task_item_layout)
        return TaskViewHolder(TaskItemLayoutBinding.bind(view))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class TaskViewHolder(private val binding: TaskItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(taskEntity: TaskEntity) {
            binding.taskTitle.text = taskEntity.title
            binding.checkBox.isChecked = taskEntity.completed

            if (taskEntity.completed) {
                //strike through text
                binding.taskTitle.apply {
                    paintFlags = binding.taskTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                }
            }

            binding.imageViewMore.setOnClickListener {
                moreClick(taskEntity,binding.imageViewMore)
            }

        }
    }
}