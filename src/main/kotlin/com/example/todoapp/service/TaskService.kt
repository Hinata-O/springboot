package com.example.todoapp.service

import com.example.todoapp.entity.Task
import com.example.todoapp.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepository: TaskRepository) {

    fun getAllTasks(): List<Task> = taskRepository.findAll()

    fun getTaskById(id: Long): Task = taskRepository.findById(id).orElseThrow { RuntimeException("タスクが見つかりません。") }

    fun createTask(task: Task): Task = taskRepository.save(task)

    fun updateTask(id: Long, task: Task): Task {
        val existingTask = getTaskById(id)
        val updatedTask = existingTask.copy(title = task.title, description = task.description, completed = task.completed)
        return taskRepository.save(updatedTask)
    }

    fun deleteTask(id: Long) {
        taskRepository.deleteById(id)
    }
}
