package com.grades.grades.controller;

import com.grades.grades.dto.EnrollmentDTO;
import com.grades.grades.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

//    // Enroll a student in multiple courses
//    @PostMapping("/student/{studentId}")
//    public ResponseEntity<List<EnrollmentDTO>> enrollStudentInCourses(
//            @PathVariable Long studentId,
//            @RequestBody List<Long> courseIds) {
//        List<EnrollmentDTO> enrollments = enrollmentService.enrollStudentInCourses(studentId, courseIds);
//        return ResponseEntity.ok(enrollments);
//    }
//
//    // Get all enrollments for a student
//    @GetMapping("/student/{studentId}")
//    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByStudent(@PathVariable Long studentId) {
//        List<EnrollmentDTO> enrollments = enrollmentService.getEnrollmentsByStudent(studentId);
//        return ResponseEntity.ok(enrollments);
//    }
//
//    // Get all enrollments for a course
//    @GetMapping("/course/{courseId}")
//    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByCourse(@PathVariable Long courseId) {
//        List<EnrollmentDTO> enrollments = enrollmentService.getEnrollmentsByCourse(courseId);
//        return ResponseEntity.ok(enrollments);
//    }
//
//    // Validate grade format and update grade for an enrollment
//    @PutMapping("/{enrollmentId}/grade")
//    public ResponseEntity<Void> updateGrade(
//            @PathVariable Long enrollmentId,
//            @RequestBody String gradeValue) {
//        enrollmentService.updateGrade(enrollmentId, gradeValue);
//        return ResponseEntity.noContent().build();
//    }
}
