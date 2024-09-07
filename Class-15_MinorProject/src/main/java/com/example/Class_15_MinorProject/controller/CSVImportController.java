package com.example.Class_15_MinorProject.controller;

import com.example.Class_15_MinorProject.service.CSVImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/csv")
public class CSVImportController {


    @Autowired
    CSVImportService csvImportService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCSV(@RequestParam("file")MultipartFile file, @RequestParam("entity") String key) {
        Integer records = null;
        try {
            records = csvImportService.processCSVandSaveStudent(file);
            return ResponseEntity.
                    ok("CSV file Parsed successfully and uploaded " + records + "records");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }

    }


}
