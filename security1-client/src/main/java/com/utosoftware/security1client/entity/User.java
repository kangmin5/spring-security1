package com.utosoftware.security1client.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private String email;
    @Column(length = 60)
    private String password;
    private String role;
    private boolean enabled = false;

}

