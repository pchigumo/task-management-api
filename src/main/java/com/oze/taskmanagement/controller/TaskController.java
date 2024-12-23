package com.oze.taskmanagement.controller;

import com.oze.taskmanagement.model.Task;
import com.oze.taskmanagement.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @author Pauline Chigumo
 * @dateCreated 2024-12-23 10:21
 * @dateModified 2024-12-23 10:21
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Operation(summary = "Create a new task.")
    public ResponseEntity<?> createTask(@RequestBody Task task, Principal principal) {
        Task createdTask = taskService.createTask(task, principal.getName());
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping
    @Operation(summary = "List all tasks for the authenticated user.")
    public ResponseEntity<?> listTasks(Principal principal) {
        List<Task> tasks = taskService.listTasksForUser(principal.getName());
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing task.")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task updated = taskService.updateTask(id, updatedTask);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a task.")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}