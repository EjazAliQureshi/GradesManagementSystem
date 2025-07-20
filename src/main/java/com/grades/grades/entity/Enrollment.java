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
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;

    @Column(insertable=false, updatable=false)
    private Long course_Id;

    @ManyToOne
    @JoinColumn(name = "course_Id")
    private Course course;

    @Column(name = "grade")
    private String grade;


}

