package com.oze.taskmanagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @author Pauline Chigumo
 * @dateCreated 2024-12-23 10:00
 * @dateModified 2024-12-23 10:00
 */
@Entity
@Schema(description = "Represents a task in the task management system.")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the task.", example = "101")
    private Long id;

    @Schema(description = "Title of the task.", example = "Complete assessment")
    private String title;

    @Schema(description = "Description of the task.", example = "Finish the take-home assignment.")
    private String description;

    @Schema(description = "Status of the task.", example = "In Progress")
    private String status;

    @Schema(description = "Due date of the task.", example = "2024-12-31")
    private LocalDate dueDate;

    @ManyToOne
    @Schema(description = "The user to whom this task is assigned.")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

