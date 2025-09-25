package com.taskManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskManagement.model.Task;
import com.taskManagement.service.TaskService;


@CrossOrigin(origins = "http://localhost:3333") 
@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	
    private TaskService taskService;
    
    
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) { 
        taskService.addTask(task);
        return task;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        taskService.updateTask(task);
        return task;
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        Task t = taskService.getTask(id);
        if(t != null) {
            taskService.deleteTask(t);
            return "deleted";
        }
        return "not found";
    }
}
