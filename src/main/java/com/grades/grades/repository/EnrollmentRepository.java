package com.grades.grades.repository;

import com.grades.grades.dto.StudentGradeDTO;
import com.grades.grades.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    @Query("SELECT new com.grades.grades.dto.StudentGradeDTO(s.id, s.name, c.name, e.grade) " +
            "FROM Enrollment e " +
            "JOIN e.course c " +
            "JOIN e.studentId s " +
            "WHERE s.id = :studentId")
    List<StudentGradeDTO> findGradesByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT new com.grades.grades.dto.StudentGradeDTO(s.id, s.name, c.name, e.grade) " +
            "FROM Enrollment e " +
            "JOIN e.course c " +
            "JOIN e.studentId s")
    List<StudentGradeDTO>findAllGrades();
}

