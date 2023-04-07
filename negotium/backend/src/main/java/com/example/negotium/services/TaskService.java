package com.example.negotium.services;

import java.util.List;

import com.example.negotium.models.Task;

// Interface
public interface TaskService {

    // Save operation
    Task saveTask(Task department);

    // Read operation
    List<Task> fetchTaskList();

    // Update operation
    Task updateTask(Task task,
            Long taskId);

    // Delete operation
    void deleteTaskById(Long taskId);
}
