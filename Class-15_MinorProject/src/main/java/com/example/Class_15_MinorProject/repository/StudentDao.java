package com.example.Class_15_MinorProject.repository;

import com.example.Class_15_MinorProject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {
    Student findStudentByRollNumber(String rollNumber);
    Student findStudentByEmail(String email);
}
