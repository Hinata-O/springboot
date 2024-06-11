package com.example.todoapp.controller

import com.example.todoapp.entity.Task
import com.example.todoapp.service.TaskService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun getAllTasks(model: Model): String {
        model.addAttribute("tasks", taskService.getAllTasks())
        return "tasks"
    }

    @GetMapping("/new")
    fun showCreateForm(model: Model): String {
        model.addAttribute("task", Task())
        return "task-form"
    }

    @PostMapping
    fun createTask(@ModelAttribute task: Task): String {
        taskService.createTask(task)
        return "redirect:/tasks"
    }

    @GetMapping("/edit/{id}")
    fun showUpdateForm(@PathVariable id: Long, model: Model): String {
        val task = taskService.getTaskById(id)
        model.addAttribute("task", task)
        return "task-form"
    }

    @PostMapping("/update/{id}")
    fun updateTask(@PathVariable id: Long, @ModelAttribute task: Task): String {
        taskService.updateTask(id, task)
        return "redirect:/tasks"
    }

    @GetMapping("/delete/{id}")
    fun deleteTask(@PathVariable id: Long): String {
        taskService.deleteTask(id)
        return "redirect:/tasks"
    }
}
