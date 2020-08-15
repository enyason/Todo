package com.enyason.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.enyason.todo.App
import com.enyason.todo.R
import com.enyason.todo.ViewModelProvider
import com.enyason.todo.databinding.FragmentAddTaskBinding

class EditTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private lateinit var viewModel: TaskViewModel

    private val args: EditTaskFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val appContainer = (requireActivity().applicationContext as App).appContainer
        viewModel = ViewModelProvider(appContainer.taskRepository).create(TaskViewModel::class.java)

        binding = FragmentAddTaskBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //update views to match edit task
        binding.btnSave.text = getString(R.string.text_updte)

        binding.taskName.setText(args.task.title)
        binding.taskDescription.setText(args.task.description)

        binding.btnSave.setOnClickListener {
            updateTask()
        }

    }

    private fun updateTask() {

        val name = binding.taskName.text.toString()
        val description = binding.taskDescription.text.toString()

        //update task state
        val taskNew = args.task.copy(title = name, description = description)

        viewModel.updateTask(taskNew)
            .also { findNavController().popBackStack() }

    }

}