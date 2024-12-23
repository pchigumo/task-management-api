package com.oze.taskmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author Pauline Chigumo
 * @dateCreated 2024-12-23 08:31
 * @dateModified 2024-12-23 08:31
 */
@Entity
@Schema(description = "Represents a user in the task management system.")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the user.", example = "1")
    private Long id;

    @Schema(description = "Username of the user.", example = "paulinechigumo")
    private String username;

    @Schema(description = "Email address of the user.", example = "johndoe@example.com")
    private String email;

    @Schema(description = "Password of the user.")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

