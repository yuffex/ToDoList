package com.example.todolist.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.domain.model.Task
import com.example.todolist.domain.repostitory.TaskRepository
import com.example.todolist.domain.useCase.TaskUseCase


class TaskViewModel(private val taskUseCase: TaskUseCase) : ViewModel() {
    private val _taskList = MutableLiveData<List<Task>>()
    val taskList: LiveData<List<Task>> = _taskList

    init {
        loadTasks()
    }

    fun loadTasks() {
        _taskList.value = taskUseCase.getAllTasks()
    }

    fun addTask(title: String) {
        taskUseCase.addTask(title)
        loadTasks()
    }

    fun updateTask(task: Task) {
        taskUseCase.updateTask(task)
        loadTasks()
    }
}