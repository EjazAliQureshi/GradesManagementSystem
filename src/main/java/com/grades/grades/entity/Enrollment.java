package com.grades.grades.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    private Student student;
//
//    private Course course;

    @Column(name = "isCompleted")
    private boolean isCompleted;

    // Getters and setters
}

