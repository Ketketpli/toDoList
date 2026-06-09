package com.katz.toDoList.services;

import com.katz.toDoList.dtos.TaskRequestDTO;
import com.katz.toDoList.dtos.TaskResponseDTO;
import com.katz.toDoList.enums.TaskStatus;
import com.katz.toDoList.models.Task;
import com.katz.toDoList.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        Task task = new Task();
        task.setTitle(taskRequestDTO.title());
        task.setDescription(taskRequestDTO.description());
        task.setTaskDate(taskRequestDTO.taskDate());
        task.setTaskStatus(TaskStatus.PENDENT);
        Task savedTask = taskRepository.save(task);

        return new TaskResponseDTO(
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.getTaskDate(),
                savedTask.getId(),
                savedTask.getCreatedAt(),
                savedTask.getTaskStatus());
    }
}
