package com.enyason.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.enyason.todo.App
import com.enyason.todo.R
import com.enyason.todo.ViewModelProvider
import com.enyason.todo.databinding.FragmentTaskListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskListFragment : Fragment() {


    private lateinit var binding: FragmentTaskListBinding

   private val viewModel:TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTaskListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskAdapter = TaskAdapter({ taskEntity ->
            //delete task
            viewModel.deleteTask(taskEntity)

        }, { taskEntity ->

            //update task state
            val taskNew = if (taskEntity.completed) {
                taskEntity.copy(completed = false)
            } else {
                taskEntity.copy(completed = true)
            }

            viewModel.updateTask(taskNew)
            true
        },
            { taskEntity ->


                val action =
                    TaskListFragmentDirections.actionTaskListFragmentToEditTaskFragment(taskEntity)
                findNavController().navigate(action)

            })

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


        viewModel.progress.observe(viewLifecycleOwner, Observer {

            it?.let { progress ->

                binding.progressBar.progress = progress
                binding.textViewProgress.text = String.format("%s", progress)

            }
        })


    }

}