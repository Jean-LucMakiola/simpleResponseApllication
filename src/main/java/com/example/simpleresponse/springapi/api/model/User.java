package com.example.simpleresponse.springapi.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;


@Data
@Entity
@Table(name = "app_users")
public class User {
    @Setter
    @Getter
    @Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(name = "custom-id-generator", strategy = "com.example.simpleresponse.springapi.service.CustomIdGenerator")
    private int id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String email;


    public User() {}

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   
    private List<Device> devices;


}