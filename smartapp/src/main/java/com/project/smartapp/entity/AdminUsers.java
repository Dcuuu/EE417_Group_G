package com.project.smartapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "adminusers")
public class AdminUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String username;
    private String password;
    private String role;
    private String phoneNumber;
    private String email;
    private String accountNumber;

    // Constructor, getters, and setters generated from @Data
    
    // Connects to the appropriate table in the database
    // and uses matching variables
}