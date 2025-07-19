package com.grades.grades.service;

import com.grades.grades.dto.EnrollmentDTO;
import com.grades.grades.entity.Course;
import com.grades.grades.entity.Enrollment;
import com.grades.grades.entity.Student;
import com.grades.grades.entity.Grade;
import com.grades.grades.exception.ResourceNotFoundException;
import com.grades.grades.repository.CourseRepository;
import com.grades.grades.repository.EnrollmentRepository;
import com.grades.grades.repository.StudentRepository;
import com.grades.grades.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private GradeRepository gradeRepository;

    // Enroll a student in multiple courses
//    public List<EnrollmentDTO> enrollStudentInCourses(Long studentId, List<Long> courseIds) {
//        Student student = studentRepository.findById(studentId)
//                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
//        List<EnrollmentDTO> result = new ArrayList<>();
//        for (Long courseId : courseIds) {
//            Course course = courseRepository.findById(courseId)
//                    .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
//            // Check if already enrolled
//            Optional<Enrollment> existing = enrollmentRepository.findAll().stream()
//                    .filter(e -> e.getStudent().getId().equals(studentId) && e.getCourse().getId().equals(courseId))
//                    .findFirst();
//            if (existing.isPresent()) {
//                throw new ResourceNotFoundException("Student already enrolled in course: " + course.getName());
//            }
//            // Check prerequisites
////            if (course.getPrerequisites() != null && !course.getPrerequisites().isEmpty()) {
////                for (Course prereq : course.getPrerequisites()) {
////                    boolean hasPrereq = enrollmentRepository.findAll().stream()
////                        .anyMatch(e -> e.getStudent().getId().equals(studentId) &&
////                                      e.getCourse().getId().equals(prereq.getId()) &&
////                                      e.isCompleted());
////                    if (!hasPrereq) {
////                        throw new ResourceNotFoundException("Student does not meet prerequisite: " + prereq.getName());
////                    }
////                }
//            }
//            // Check capacity
//            long enrolledCount = enrollmentRepository.findAll().stream()
//                    .filter(e -> e.getCourse().getId().equals(courseId)).count();
//            if (enrolledCount >= course.getCapacity()) {
//                throw new ResourceNotFoundException("Course capacity reached for: " + course.getName());
//            }
//            Enrollment enrollment = new Enrollment();
//            enrollment.setStudent(student);
//            enrollment.setCourse(course);
//            enrollment.setCompleted(false);
//            Enrollment saved = enrollmentRepository.save(enrollment);
//            result.add(toDTO(saved));
//        }
//        return result;
//    }
//
//    // Get all enrollments for a student
//    public List<EnrollmentDTO> getEnrollmentsByStudent(Long studentId) {
//        return enrollmentRepository.findAll().stream()
//                .filter(e -> e.getStudent().getId().equals(studentId))
//                .map(this::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    // Get all enrollments for a course
//    public List<EnrollmentDTO> getEnrollmentsByCourse(Long courseId) {
//        return enrollmentRepository.findAll().stream()
//                .filter(e -> e.getCourse().getId().equals(courseId))
//                .map(this::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    // Validate grade format and update grade for an enrollment
//    public void updateGrade(Long enrollmentId, String gradeValue) {
//        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
//                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + enrollmentId));
//        if (enrollment.isCompleted()) {
//            throw new ResourceNotFoundException("Cannot update grade for completed course.");
//        }
//        // Validate grade format (A, B, C, D, F, P, NP, or numeric)
//        String gradePattern = "A|B|C|D|F|P|NP|[0-9]+(\\.[0-9]+)?";
//        if (!Pattern.matches(gradePattern, gradeValue)) {
//            throw new ResourceNotFoundException("Invalid grade format.");
//        }
//        Grade grade = new Grade();
//        grade.setEnrollment(enrollment);
//        grade.setValue(gradeValue);
//        gradeRepository.save(grade);
//    }
//
//    private EnrollmentDTO toDTO(Enrollment enrollment) {
//        EnrollmentDTO dto = new EnrollmentDTO();
//        dto.setId(enrollment.getId());
//        dto.setStudentId(enrollment.getStudent().getId());
//        dto.setCourseId(enrollment.getCourse().getId());
//        dto.setCompleted(enrollment.isCompleted());
//        return dto;
//    }
}
