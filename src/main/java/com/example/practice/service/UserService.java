package com.example.practice.service;

import java.util.List;
import java.util.Optional;

import com.example.practice.model.User;
import com.example.practice.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // we can guarantee that the email is not empty
    public boolean validateEmail(String email) {
        // regex pattern
        // [a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public User createUser(User user) {
        if (user != null && validateEmail(user.getEmail())) {
            return userRepository.save(user);
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public User updateUser(long id, User user) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
    }
}
