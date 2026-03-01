package com.example.practice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.model.User;
import com.example.practice.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping()
    public User createUser(User user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(long id) {
        return service.getUserById(id).get();
    }

    @PutMapping("{id}")
    public User updatUser(long id, User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(long id) {
        service.deleteUser(id);
    }
}
