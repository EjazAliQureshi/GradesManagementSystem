package com.grades.grades.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDTO {
    private Long id;
    private Long enrollmentId;
    private String value;
    // Getters and setters
}

