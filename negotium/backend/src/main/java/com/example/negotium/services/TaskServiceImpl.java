package com.example.negotium.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.negotium.models.Task;
import com.example.negotium.repositories.TaskRepository;

// Annotation
@Service

// Class
public class TaskServiceImpl implements TaskService {

        @Autowired
        private TaskRepository taskRepository;
        // Save operation
        @Override
        public Task saveTask(Task task) {
                return taskRepository.save(task);
        }

        // Read operation
        @Override
        public List<Task> fetchTaskList() {
                return (List<Task>) taskRepository.findAll();
        }
        // Update operation
        @Override
        public Task updateTask(
                        Task task,
                        Long taskId) {
                Task taskDB = taskRepository.findById(taskId)
                                .get();

                if (Objects.nonNull(task.getTaskName())
                                && !"".equalsIgnoreCase(
                                                task.getTaskName())) {
                        taskDB.setTaskName(
                                        task.getTaskName());
                }

                if (Objects.nonNull(
                                task.getDescription())
                                && !"".equalsIgnoreCase(
                                                task.getDescription())) {
                        taskDB.setDescription(
                                        task.getDescription());
                }

                if (Objects.nonNull(task.getTaskCategorie())) {
                        taskDB.setTaskCategorie(
                                        task.getTaskCategorie());
                }

                if (Objects.nonNull(task.getTaskDueDate())) {
                        taskDB.setTaskDueDate(
                                        task.getTaskDueDate());
                }
                if (Objects.nonNull(task.isTaskStatus())) {
                        taskDB.setTaskStatus(
                                        task.isTaskStatus());
                }

                return taskRepository.save(taskDB);
        }

        // Delete operation
        @Override
        public void deleteTaskById(Long taskId) {
                taskRepository.deleteById(taskId);
        }
}