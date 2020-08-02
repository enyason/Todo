package com.enyason.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.enyason.todo.App
import com.enyason.todo.R
import com.enyason.todo.data.mdel.TaskEntity
import com.enyason.todo.databinding.FragmentAddTaskBinding
import java.util.*


class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private lateinit var viewModel: TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val appContainer = (requireActivity().applicationContext as App).appContainer
        viewModel = com.enyason.todo.ViewModelProvider(appContainer.taskRepository)
            .create(TaskViewModel::class.java)

        binding = FragmentAddTaskBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSave.setOnClickListener {
            saveTask()
        }
    }

    private fun saveTask() {
        val title = binding.taskName.text.toString()
        val description = binding.taskDescription.text.toString()
        val id = UUID.randomUUID().toString()
        val timeCreated = Calendar.getInstance().time.time

        val task = TaskEntity(
            id = id,
            title = title,
            description = description,
            completed = false,
            timeCreated = timeCreated
        )

        viewModel.saveTask(task)

    }

}