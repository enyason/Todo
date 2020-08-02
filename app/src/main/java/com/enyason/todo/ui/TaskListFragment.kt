package com.enyason.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.enyason.todo.App
import com.enyason.todo.R
import com.enyason.todo.ViewModelProvider
import com.enyason.todo.databinding.FragmentTaskListBinding

class TaskListFragment : Fragment() {


    private lateinit var binding: FragmentTaskListBinding

    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val appContainer = (requireActivity().applicationContext as App).appContainer
        viewModel = ViewModelProvider(appContainer.taskRepository).create(TaskViewModel::class.java)

        binding = FragmentTaskListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskAdapter = TaskAdapter()

        binding.taskRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = taskAdapter
        }

        viewModel.tasks.observe(viewLifecycleOwner, Observer {
            taskAdapter.submitList(it)
        })

        binding.fabAddTask.setOnClickListener {
            findNavController().navigate(R.id.action_taskListFragment_to_addTaskFragment)
        }

    }

}