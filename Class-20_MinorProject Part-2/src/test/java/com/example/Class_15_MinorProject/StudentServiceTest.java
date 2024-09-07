package com.example.Class_15_MinorProject;

import com.example.Class_15_MinorProject.models.Student;
import com.example.Class_15_MinorProject.repository.StudentDao;
import com.example.Class_15_MinorProject.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceTest {

    @Mock
    private StudentDao mockStudentDao;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testFindStudentByEmail() throws Exception {

        String searchKey = "email";
        String searchValue = "ashishgulati21@gmail.com";

        Student expectedStudent = Student.builder()
                                .id(1)
                                .name("John")
                                .age(12)
                                .email(searchValue)
                                .rollNumber("12")
                                .build();

        when(mockStudentDao.findStudentByEmail(searchValue)).thenReturn(expectedStudent);
        Student actualStudent = studentService.findStudent(searchKey, searchValue);
        Assertions.assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void testFindStudentByRollNumber() throws Exception {

        String searchKey = "rollNumber";
        String searchValue = "12";

        Student expectedStudent = Student.builder()
                .id(1)
                .name("John")
                .age(12)
                .email("ashishgulati21@gmail.com")
                .rollNumber("12")
                .build();

        when(mockStudentDao.findStudentByRollNumber(searchValue)).thenReturn(expectedStudent);
        Student actualStudent = studentService.findStudent(searchKey, searchValue);
        Assertions.assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void testFindStudentById() throws Exception {

        String searchKey = "id";
        String searchValue = "1";

        Student expectedStudent = Student.builder()
                .id(1)
                .name("John")
                .age(12)
                .email("ashishgulati21@gmail.com")
                .rollNumber("12")
                .build();

        when(mockStudentDao.findById(Integer.parseInt(searchValue))).thenReturn(Optional.ofNullable(expectedStudent));
        Student actualStudent = studentService.findStudent(searchKey, searchValue);
        Assertions.assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void testFindStudentByInvalidSearchKey() throws Exception {
        String searchKey = "name";
        String searchValue = "1";

        assertThrows(Exception.class, () -> studentService.findStudent(searchKey, searchValue));
    }







}
