package com.grades.grades.controller;

import com.grades.grades.dto.EnrollmentDTO;
import com.grades.grades.dto.StudentGradeDTO;
import com.grades.grades.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentDTO> createEnrollment(@RequestBody EnrollmentDTO dto) {
        return ResponseEntity.ok(enrollmentService.createEnrollment(dto));
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> getAll() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@PathVariable Long id, @RequestBody EnrollmentDTO dto) {
        return ResponseEntity.ok(enrollmentService.updateEnrollment(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/student/{studentId}/grades")
    public ResponseEntity<List<StudentGradeDTO>> getGradesForStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(enrollmentService.getGradesByStudentId(studentId));
    }

    @GetMapping("/student/grades")
    public ResponseEntity<List<StudentGradeDTO>> getAllGradesForStudent() {
        return ResponseEntity.ok(enrollmentService.getAllGrades());
    }
}
