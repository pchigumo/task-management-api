package com.oze.taskmanagement.repository;

import com.oze.taskmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pauline Chigumo
 * @dateCreated 2024-12-23 08:39
 * @dateModified 2024-12-23 08:39
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
