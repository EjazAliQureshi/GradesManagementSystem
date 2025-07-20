package com.grades.grades.service;

import com.grades.grades.dto.EnrollmentDTO;
import com.grades.grades.dto.StudentGradeDTO;
import com.grades.grades.entity.Course;
import com.grades.grades.entity.Enrollment;
import com.grades.grades.entity.Student;
import com.grades.grades.repository.CourseRepository;
import com.grades.grades.repository.EnrollmentRepository;
import com.grades.grades.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public EnrollmentDTO createEnrollment(EnrollmentDTO dto) {
        Enrollment enrollment = new Enrollment();
        enrollment.setGrade(dto.getGrade());

        Student student = studentRepository.findById(dto.getStudentId())
                                           .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(dto.getCourseId())
                                        .orElseThrow(() -> new RuntimeException("Course not found"));

        enrollment.setStudentId(student);
        enrollment.setCourse(course);

        enrollment = enrollmentRepository.save(enrollment);
        return mapToDTO(enrollment);
    }

    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentRepository.findAll()
                                   .stream()
                                   .map(this::mapToDTO)
                                   .collect(Collectors.toList());
    }

    public EnrollmentDTO getEnrollmentById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                                                    .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        return mapToDTO(enrollment);
    }

    public EnrollmentDTO updateEnrollment(Long id, EnrollmentDTO dto) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                                                    .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        Student student = studentRepository.findById(dto.getStudentId())
                                           .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(dto.getCourseId())
                                        .orElseThrow(() -> new RuntimeException("Course not found"));

        enrollment.setStudentId(student);
        enrollment.setCourse(course);
        enrollment.setGrade(dto.getGrade());

        return mapToDTO(enrollmentRepository.save(enrollment));
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public List<StudentGradeDTO> getGradesByStudentId(Long studentId) {
        return enrollmentRepository.findGradesByStudentId(studentId);
    }

    public List<StudentGradeDTO> getAllGrades(){
        return enrollmentRepository.findAllGrades();
    }

    private EnrollmentDTO mapToDTO(Enrollment enrollment) {
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(enrollment.getId());
        dto.setStudentId(enrollment.getStudentId().getId());
        dto.setCourseId(enrollment.getCourse().getId());
        dto.setGrade(enrollment.getGrade());
        return dto;
    }
}
