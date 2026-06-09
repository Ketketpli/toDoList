package com.katz.toDoList.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record TaskRequestDTO(
        @NotBlank(message = "Título é obrigatório") @Size(max = 100) String title,
        @Size(max = 500) String description,
        @NotNull(message = "Horário é obrigatório") LocalDateTime taskDate) {}
