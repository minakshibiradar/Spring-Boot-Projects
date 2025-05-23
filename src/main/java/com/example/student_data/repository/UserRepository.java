package com.example.student_data.repository;

// src/main/java/com/example/demo/repository/UserRepository.java


import com.example.student_data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

