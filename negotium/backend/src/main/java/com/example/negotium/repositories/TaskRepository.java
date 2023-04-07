package com.example.negotium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.negotium.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Task findByName(String taskName);
}
