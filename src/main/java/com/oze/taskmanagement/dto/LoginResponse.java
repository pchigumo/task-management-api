package com.oze.taskmanagement.dto;

/**
 * @author Pauline Chigumo
 * @dateCreated 2024-12-23 08:48
 * @dateModified 2024-12-23 08:48
 */
public class LoginResponse {

    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
