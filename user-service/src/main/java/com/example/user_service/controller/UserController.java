package com.example.user_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public List<User> getAllUsers() {
        return List.of(new User(1, "John Doe"), new User(2, "Jane Smith"));
    }

    
}
