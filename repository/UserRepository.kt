package com.example.springboot.repository

import com.example.springboot.entity.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Users, Int>
