package com.oze.taskmanagement.repository;

import com.oze.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Pauline Chigumo
 * @dateCreated 2024-12-23 10:03
 * @dateModified 2024-12-23 10:03
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
}
