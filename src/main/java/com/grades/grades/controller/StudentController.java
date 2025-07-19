package com.grades.grades.controller;

import com.grades.grades.dto.StudentDTO;
import com.grades.grades.entity.Student;
import com.grades.grades.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    // CRUD endpoints for students

    @Autowired
    private StudentService studentService;

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudents(@PathVariable Long id){
        StudentDTO s = studentService.getStudents(id);
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudent() {
        List<StudentDTO> studentDTOS = studentService.getAllStudent();
        return ResponseEntity.ok(studentDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO updatedStudent) {
        StudentDTO updated = studentService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok(updated);
    }
}

