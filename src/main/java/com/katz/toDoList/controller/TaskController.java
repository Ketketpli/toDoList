package com.katz.toDoList.controller;

import com.katz.toDoList.dtos.TaskRequestDTO;
import com.katz.toDoList.dtos.TaskResponseDTO;
import com.katz.toDoList.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/createTask")
    public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO taskRequestDTO) {
        TaskResponseDTO newTask = this.taskService.createTask(taskRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getTask() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasks());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable String id, @RequestBody TaskRequestDTO taskRequestDTO) {
        TaskResponseDTO updatedTask = this.taskService.updateTask(id, taskRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTask);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id) {
        String message = taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

}
