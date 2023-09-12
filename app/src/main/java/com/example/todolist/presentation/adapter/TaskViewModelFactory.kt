package com.example.todolist.presentation.adapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.domain.repostitory.TaskRepository
import com.example.todolist.domain.useCase.TaskUseCase
import com.example.todolist.presentation.viewModel.TaskViewModel


class TaskViewModelFactory(private val taskUseCase: TaskUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            return TaskViewModel(taskUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}