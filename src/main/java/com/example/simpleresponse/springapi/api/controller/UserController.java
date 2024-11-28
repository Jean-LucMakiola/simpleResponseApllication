package com.example.simpleresponse.springapi.api.controller;

import com.example.simpleresponse.springapi.api.model.User;
import com.example.simpleresponse.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    @GetMapping("/user/id")
    public Optional<User> findUserByID(@RequestParam Integer id) {
        return userService.findUserByID(id);
    }

    @GetMapping("/user/name")
    public List<User> findByName(@RequestParam String name) {
        return userService.findByName(name);
    }


    @GetMapping("/user/email")
    public List<User> findByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam Integer id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/user")
    public void updateUser(@RequestParam int id,@RequestBody User user) {
        userService.updateUser(id ,user);
    }

    @PatchMapping("/user/email")
    public Optional<User> updateUserEmail(@RequestParam int id, @RequestParam String email) {
        userService.updateUserEmail(id, email);
        return userService.findUserByID(id);
    }
    @PatchMapping("/user/name")
    public Optional<User> updateUserName(@RequestParam int id, @RequestParam String name) {
        userService.updateUserName(id, name);
        return userService.findUserByID(id);
    }


}
