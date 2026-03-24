package com.TD.spring_introduction.service;


import com.TD.spring_introduction.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> studentsInMemory = new ArrayList<>();

    public List<Student> addAll (List<Student> newStudents) {
        this.studentsInMemory.addAll(newStudents);
        return this.studentsInMemory;
    }
}
