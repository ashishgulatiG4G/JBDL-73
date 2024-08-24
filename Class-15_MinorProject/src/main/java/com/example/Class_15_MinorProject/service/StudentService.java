package com.example.Class_15_MinorProject.service;

import com.example.Class_15_MinorProject.models.Student;
import com.example.Class_15_MinorProject.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public void createOrUpdate(Student student) {
        studentDao.save(student);
    }

    public Student findStudent(String searchKey, String searchValue) throws Exception {
        return switch(searchKey) {
            case "email" -> studentDao.findStudentByEmail(searchValue);
            case "rollNumber" -> studentDao.findStudentByRollNumber(searchValue);
            case "id" ->
                studentDao.findById(Integer.parseInt(searchValue)).orElse(new Student());
            default -> throw new Exception("Search key is not valid: " + searchKey);
        };
    }
}
