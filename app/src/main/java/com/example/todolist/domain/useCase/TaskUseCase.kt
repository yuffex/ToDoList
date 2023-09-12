package com.example.todolist.domain.useCase

import com.example.todolist.domain.model.Task
import com.example.todolist.domain.repostitory.TaskRepository

class TaskUseCase(private val repository: TaskRepository) {
    fun getAllTasks(): List<Task> {
        return repository.getAllTasks()
    }

    fun addTask(title: String) {
        val newTask = Task(repository.getAllTasks().size, title, false)
    }

    fun updateTask(task: Task) {
        repository.updateTask(task)
    }
}