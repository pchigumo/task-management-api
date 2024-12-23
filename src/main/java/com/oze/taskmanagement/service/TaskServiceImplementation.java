package com.oze.taskmanagement.service;

import com.oze.taskmanagement.model.Task;
import com.oze.taskmanagement.model.User;
import com.oze.taskmanagement.repository.TaskRepository;
import com.oze.taskmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pauline Chigumo
 * @dateCreated 2024-12-23 10:05
 * @dateModified 2024-12-23 10:05
 */
@Service
public class TaskServiceImplementation implements TaskService{

    private TaskRepository taskRepository;

    private UserRepository userRepository;

    public TaskServiceImplementation(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(Task task, String username) {
        User user = userRepository.findByUsername(username);
        task.setUser(user);
        return taskRepository.save(task);
    }

    public List<Task> listTasksForUser(String username) {
        User user = userRepository.findByUsername(username);
        return taskRepository.findByUserId(user.getId());
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setDueDate(updatedTask.getDueDate());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}