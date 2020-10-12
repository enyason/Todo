package com.enyason.todo.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun ViewGroup.inflate(layout: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layout, this, attachToRoot)
}

//private fun showPopUp(taskEntity: TaskEntity, anchor:View) {
//
//
//
//        with(PopupWindow(popUpContentBinding.root, 200, WRAP_CONTENT)) {
//
//            popUpContentBinding.actionEdit.setOnClickListener {
//
//
//                val action =
//                    TaskListFragmentDirections.actionTaskListFragmentToEditTaskFragment(taskEntity)
//                findNavController().navigate(action).also { dismiss() }
//            }
//
//            popUpContentBinding.actionUpdate.setOnClickListener {
//
//                //update task state
//                val taskNew = if (taskEntity.completed) {
//                    taskEntity.copy(completed = false)
//                } else {
//                    taskEntity.copy(completed = true)
//                }
//
//                viewModel.updateTask(taskNew).also { dismiss() }
//            }
//
//            popUpContentBinding.actionDelete.setOnClickListener {
//                //delete task
//                viewModel.deleteTask(taskEntity).also { dismiss() }
//            }
//
//            isOutsideTouchable = true
//            showAsDropDown(anchor,0,0,Gravity.END)
//        }
//
//    }