package com.example.simpleresponse.springapi.api.controller;

import com.example.simpleresponse.springapi.api.model.User;
import com.example.simpleresponse.springapi.api.repo.UserRepo;
import com.example.simpleresponse.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
        //userRepo.save(user);
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userService.findAll();
    }
    @GetMapping("/user")
    public Optional<User> findUserByID(@RequestParam Integer id) {
        return userService.findUserByID(id);
    }

    /*@DeleteMapping("/user")
    public void deleteUser(@RequestParam Integer id) {
        userService.deleteUserById(id);
    }*/

}
