package com.grades.grades.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentGradeDTO {
    private Long studentId;
    private String studentName;
    private String courseName;
    private String grade;


}
