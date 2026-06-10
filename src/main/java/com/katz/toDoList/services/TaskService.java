package com.katz.toDoList.services;

import com.katz.toDoList.dtos.TaskRequestDTO;
import com.katz.toDoList.dtos.TaskResponseDTO;
import com.katz.toDoList.enums.TaskStatus;
import com.katz.toDoList.exceptions.TaskNotFoundException;
import com.katz.toDoList.models.Task;
import com.katz.toDoList.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.System.*;

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

    public List<TaskResponseDTO> getTasks() {
        List<Task> newTaskList = this.taskRepository.findAll();
        return newTaskList.stream()
                .map(task -> new TaskResponseDTO(task.getTitle(), task.getDescription(), task.getTaskDate(), task.getId(), task.getCreatedAt(), task.getTaskStatus()))
                .toList();
    }

    public TaskResponseDTO updateTask(String id, TaskRequestDTO taskRequestDTO) {
        Task task;
        task = taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
        task.setTitle(taskRequestDTO.title());
        task.setDescription(taskRequestDTO.description());
        task.setTaskDate(taskRequestDTO.taskDate());
        task.setTaskStatus(taskRequestDTO.taskStatus());
        Task savedTask = taskRepository.save(task);

        return new TaskResponseDTO(
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.getTaskDate(),
                savedTask.getId(),
                savedTask.getCreatedAt(),
                savedTask.getTaskStatus());
    }

    public String deleteTask(String id) {
        taskRepository.deleteById(id);
        return "Tarefa deletada com sucesso!";
    }
}
