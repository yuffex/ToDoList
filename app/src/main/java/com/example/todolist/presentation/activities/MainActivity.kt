package com.example.todolist.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.R
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.domain.repostitory.TaskRepository
import com.example.todolist.domain.useCase.TaskUseCase
import com.example.todolist.presentation.adapter.TaskAdapter
import com.example.todolist.presentation.viewModel.TaskViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val taskViewModel: TaskViewModel by lazy {
        ViewModelProvider(this)[TaskViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val taskAdapter = TaskAdapter(taskViewModel.taskList.value ?: emptyList()) { task ->
            // Обработка нажатия на задачу
            taskViewModel.updateTask(task)
        }

        binding.recyclerViewTasks.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = taskAdapter
        }

        taskViewModel.taskList.observe(this) { tasks ->
            taskAdapter.updateTasks(tasks)
        }

        binding.buttonAddTask.setOnClickListener {
            val taskTitle = binding.editTextTask.text.toString().trim()
            if (taskTitle.isNotEmpty()) {
                taskViewModel.addTask(taskTitle)
                binding.editTextTask.text.clear()
            }
        }
    }
}