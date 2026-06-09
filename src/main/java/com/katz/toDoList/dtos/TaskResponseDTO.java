package com.katz.toDoList.dtos;

import com.katz.toDoList.enums.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponseDTO(String title,
                              String description,
                              LocalDateTime taskDate,
                              String id,
                              LocalDateTime createdAt,
                              TaskStatus taskStatus) {}
