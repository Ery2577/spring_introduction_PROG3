package com.TD.spring_introduction.controller;

import com.TD.spring_introduction.model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}