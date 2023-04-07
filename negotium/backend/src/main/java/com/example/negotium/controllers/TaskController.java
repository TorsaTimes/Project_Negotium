package com.example.negotium.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.negotium.models.Task;
import com.example.negotium.services.TaskService;

// Annotation
// @CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/task")
// Class
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Save operation
    @PostMapping("/tasks")
    public Task saveDepartment(
            @Validated @RequestBody Task task) {
        return taskService.saveTask(task);
    }

    // Read operation
    @GetMapping("/tasks")
    public List<Task> fetchTaskList() {
        return taskService.fetchTaskList();
    }

    // Update operation
    @PutMapping("/tasks/{id}")
    public Task updateDepartment(@RequestBody Task task,
            @PathVariable("id") Long taskId) {
        return taskService.updateTask(
                task, taskId);
    }

    // Delete operation
    @DeleteMapping("/tasks/{id}")
    public String deleteTaskById(@PathVariable("id") Long taskId) {
        taskService.deleteTaskById(
                taskId);

        return "Deleted Successfully";
    }
}
