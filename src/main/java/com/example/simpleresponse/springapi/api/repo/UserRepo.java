package com.example.simpleresponse.springapi.api.repo;

import com.example.simpleresponse.springapi.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
    List<User> findByEmail(String email);
}
