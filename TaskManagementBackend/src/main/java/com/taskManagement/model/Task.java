package com.taskManagement.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task") // optional
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id;

    private String title;
    private String description;
    private String priority;

    public Task() {}

    public Task(String title, String description, String priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
}
