package com.enyason.todo.ui

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.WindowManager.LayoutParams.WRAP_CONTENT
import android.widget.PopupWindow
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.enyason.todo.App
import com.enyason.todo.R
import com.enyason.todo.ViewModelProvider
import com.enyason.todo.data.model.TaskEntity
import com.enyason.todo.databinding.FragmentTaskListBinding
import com.enyason.todo.databinding.PopUpContentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@RequiresApi(Build.VERSION_CODES.KITKAT)
class TaskListFragment : Fragment() {


    private lateinit var binding: FragmentTaskListBinding

    private val viewModel: TaskViewModel by viewModels()

    private val popUpContentBinding by lazy {
        PopUpContentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTaskListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskAdapter = TaskAdapter { taskEntity, view ->

        }

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