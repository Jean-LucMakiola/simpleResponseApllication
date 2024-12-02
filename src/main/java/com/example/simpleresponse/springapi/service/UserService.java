package com.example.simpleresponse.springapi.service;

import com.example.simpleresponse.springapi.api.model.User;
import com.example.simpleresponse.springapi.api.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepository;

    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }


    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findUserByID(Integer id) {
        return userRepository.findById(id); // Returns an Optional<User>
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public void deleteUserById(Integer id) {
        // Find the user to delete
        User userToDelete = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        // Delete the user
        userRepository.delete(userToDelete);
    }

    public void updateUser(Integer id, User user) {
        Optional<User> userToUpdate = findUserByID(id);
        System.out.println("Hallo"+userToUpdate.isPresent());
        if (userToUpdate.isPresent()) {
            User updatedUser = userToUpdate.orElseThrow(() -> new RuntimeException("Something went wrong"));
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            userRepository.save(updatedUser);
        }
        else {
            addUser(user);
        }
    }

    public void updateUserEmail(int id, String email) {
        Optional<User> userToUpdate = findUserByID(id);
        User updatedUser = userToUpdate.orElseThrow(() -> new RuntimeException("User not found"));
        updatedUser.setEmail(email);
        userRepository.save(updatedUser);
    }

    public void updateUserName(int id, String name) {
        Optional<User> userToUpdate = findUserByID(id);
        User updatedUser = userToUpdate.orElseThrow(() -> new RuntimeException("User not found"));
        updatedUser.setName(name);
        userRepository.save(updatedUser);
    }
}

