package com.oze.taskmanagement.service;

import com.oze.taskmanagement.model.Task;

import java.util.List;

/**
 * @author Pauline Chigumo
 * @dateCreated 2024-12-23 10:04
 * @dateModified 2024-12-23 10:04
 */
public interface TaskService {

    Task createTask(Task task, String username);
    List<Task> listTasksForUser(String username);
    Task updateTask(Long id, Task updatedTask);
    void deleteTask(Long id);
}
