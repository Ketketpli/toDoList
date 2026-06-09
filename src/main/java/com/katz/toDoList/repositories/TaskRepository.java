package com.katz.toDoList.repositories;

import com.katz.toDoList.enums.TaskStatus;
import com.katz.toDoList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {

    List<Task> findByTaskStatus(TaskStatus taskStatus);
}
