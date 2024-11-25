package com.example.simpleresponse.springapi.service;

import com.example.simpleresponse.springapi.api.model.User;
import com.example.simpleresponse.springapi.api.repo.UserRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    /*public void deleteUserById(Integer id) {
        // Find the user to delete
        User userToDelete = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        // Get the ID of the user to delete
        Integer deletedId = userToDelete.getId();

        // Delete the user
        userRepository.delete(userToDelete);

        // Update IDs of remaining users
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getId() > deletedId) {
                user.setId(user.getId() - 1); // Decrement ID by 1
                userRepository.save(user); // Save updated ID back to DB
            }
        }
    }*/

}

