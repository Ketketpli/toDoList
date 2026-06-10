package com.katz.toDoList.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.katz.toDoList.enums.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponseDTO(String title,
                              String description,
                              @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime taskDate,
                              String id,
                              LocalDateTime createdAt,
                              TaskStatus taskStatus) {}
