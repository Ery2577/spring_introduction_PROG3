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

    @PostMapping("/student")
    public List<Student> addStudent(@RequestBody List<Student> newStudents) {
        studentsMemory.addAll(newStudents);
        return studentsMemory;
    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudentsNames(@RequestHeader(value = "Accept", defaultValue = "text/plain") String acceptHeader){
        if ("text/plain".equalsIgnoreCase(acceptHeader)){
            String names = studentsMemory
                    .stream()
                    .map(Student::getName)
                    .collect(Collectors.joining(", "));
            return ResponseEntity.ok(names);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Format not supported");
        }
    }
}