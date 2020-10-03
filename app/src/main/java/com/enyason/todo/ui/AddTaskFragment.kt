package com.enyason.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.enyason.todo.App
import com.enyason.todo.data.model.TaskEntity
import com.enyason.todo.databinding.FragmentAddTaskBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private val viewModel:TaskViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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

        viewModel.saveTask(task).also {
            findNavController().popBackStack()
        }

    }

}