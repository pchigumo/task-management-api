package com.oze.taskmanagement.service;

import com.oze.taskmanagement.dto.LoginRequest;
import com.oze.taskmanagement.model.User;
import org.springframework.stereotype.Service;

/**
 * @author Pauline Chigumo
 * @dateCreated 2024-12-23 08:40
 * @dateModified 2024-12-23 08:40
 */
@Service
public interface UserService {

    User registerUser(User user);
    String loginUser(LoginRequest loginRequest);
}
