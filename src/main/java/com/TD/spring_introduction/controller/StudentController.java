package com.TD.spring_introduction.controller;

import com.TD.spring_introduction.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private static List<Student> studentsMemory = new ArrayList<>();

    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> newStudents) {
        try {
            studentsMemory.addAll(newStudents);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(studentsMemory);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(
            @RequestHeader(value = "Accept", required = false) String acceptHeader) {

        try {
            if (acceptHeader == null || acceptHeader.isBlank()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("The head 'Accept' is obligatory");
            }

            if (acceptHeader.contains("text/plain")) {
                String names = studentsMemory.stream()
                        .map(Student::getName)
                        .collect(Collectors.joining(", "));
                return ResponseEntity.ok(names);
            }

            else if (acceptHeader.contains("application/json")) {
                return ResponseEntity.ok(studentsMemory);
            }

            else {
                return ResponseEntity
                        .status(HttpStatus.NOT_IMPLEMENTED)
                        .body("Format not supported");
            }

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}