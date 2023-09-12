package com.example.todolist.domain.repostitory

import com.example.todolist.domain.model.Task

class TaskRepository {
    private val tasks = mutableListOf<Task>()

    fun getAllTasks(): List<Task> {
        return tasks.toList()
    }

    fun addTasks(task: Task) {
        tasks.add(task)
    }

    fun updateTask(task: Task) {
        val index = tasks.indexOfFirst { it.id == task.id }
        if (index != 1) {
            tasks[index] = task
        }
    }
}