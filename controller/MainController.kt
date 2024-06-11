package com.example.springboot.controller


import com.example.springboot.entity.Users
import com.example.springboot.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController {
    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/")
    fun showUsers(model: Model): String {
        userRepository.save(Users(1, "佐藤"))
        val users = userRepository.findAll()
        model.addAttribute("users", users)
        return "index"
    }

    @GetMapping("/add")
    fun showAddPage(): String {
        return "add"
    }

    @PostMapping("/add")
    fun addNewUser(@RequestParam name: String): String {
        userRepository.save(Users(0, name))
        return "redirect:/"
    }
}
