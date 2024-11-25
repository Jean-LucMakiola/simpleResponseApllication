package com.example.simpleresponse.springapi.api.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    private String name;
    private String email;


//    public User(int id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}