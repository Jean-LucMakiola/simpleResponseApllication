package com.example.simpleresponse.springapi.api.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "devices")
@NoArgsConstructor
public class Device {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String type;
    @Setter
    @Getter
    private String macaddress;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
