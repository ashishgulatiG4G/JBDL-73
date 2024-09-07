package com.example.Class_15_MinorProject.service;

import com.example.Class_15_MinorProject.models.Student;
import com.example.Class_15_MinorProject.repository.StudentDao;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVImportService {

    @Autowired
    StudentDao studentDao;

    public Integer processCSVandSaveStudent(MultipartFile file) throws Exception {
        try {
            List<Student> students = parseCSVToStudents(file.getInputStream());
            studentDao.saveAll(students);
            return students.size();
        } catch (IOException e) {
            throw new Exception("Unable to parse csv");
        }
    }

    private List<Student> parseCSVToStudents(InputStream inputStream) {
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8)
        )) {

            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader("Name", "Age", "Email", "RollNumber")
                    .build();

            CSVParser csvParser = csvFormat.parse(reader);
            List<CSVRecord> csvRecords = csvParser.getRecords();
            csvRecords.removeFirst();

            List<Student> students = new ArrayList<>();
            for(CSVRecord csvRecord : csvRecords) {
                Student student = Student.builder()
                        .name(csvRecord.get("Name"))
                        .age(Integer.parseInt(csvRecord.get("Age")))
                        .rollNumber(csvRecord.get("RollNumber"))
                        .email(csvRecord.get("Email"))
                        .build();

                students.add(student);
            }

            return students;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
