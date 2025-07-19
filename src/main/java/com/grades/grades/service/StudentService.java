package com.grades.grades.service;

import com.grades.grades.dto.CourseDTO;
import com.grades.grades.dto.StudentDTO;
import com.grades.grades.entity.Course;
import com.grades.grades.entity.Student;
import com.grades.grades.repository.CourseRepository;
import com.grades.grades.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService {
    // Business logic for student CRUD and validation

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public StudentDTO getStudents(Long id){
       Student s = studentRepository.getById(id);
       StudentDTO studentDTO = new StudentDTO();
       studentDTO.setId(s.getId());
       studentDTO.setName(s.getName());
       return studentDTO;
    }

    public List<StudentDTO> getAllStudent() {
        return studentRepository.findAll().stream()
                                .map(this::convertToDto)
                                .collect(Collectors.toList());
    }

    private StudentDTO convertToDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());


        List<CourseDTO> courseDTOs = student.getCourses().stream()
                                            .map(course -> {
                                                CourseDTO courseDTO = new CourseDTO();
                                                courseDTO.setId(course.getId());
                                                courseDTO.setName(course.getName());
                                                courseDTO.setDescription(course.getDescription());
                                                return courseDTO;
                                            })
                                            .collect(Collectors.toList());

        dto.setCourseDTO(courseDTOs);

        return dto;
    }
    public StudentDTO updateStudent(Long id, StudentDTO updatedStudentDTO) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        student.setName(updatedStudentDTO.getName());
        List<Course> updatedCourses = updatedStudentDTO.getCourseDTO().stream().map(courseDTO -> courseRepository.findById(courseDTO.getId()).orElseThrow(() -> new RuntimeException("Course not found: " + courseDTO.getId()))).collect(Collectors.toList());

        student.setCourses(updatedCourses);
        Student savedStudent = studentRepository.save(student);
        return convertToDto(savedStudent);
    }
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

}

