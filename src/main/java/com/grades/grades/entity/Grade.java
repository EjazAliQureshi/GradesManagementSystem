package com.grades.grades.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    private Enrollment enrollment;
    @Column(name = "value")
    private String value;

    // Getters and setters
}

