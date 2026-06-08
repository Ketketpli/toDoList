package com.katz.toDoList.models;

import com.katz.toDoList.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "task")
@Table(name = "task")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    private LocalDateTime createdAt;
    private String title;
    private String description;
    private LocalDateTime taskDate;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
