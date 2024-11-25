package com.example.simpleresponse.springapi.api.repo;

import com.example.simpleresponse.springapi.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Integer> {}
