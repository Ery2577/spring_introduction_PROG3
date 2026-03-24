package com.TD.spring_introduction.Controller;

import com.TD.spring_introduction.Entity.Student;
import com.TD.spring_introduction.service.StudentService;
import com.TD.spring_introduction.service.StudentValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;
    private final StudentValidator studentValidator;

    public StudentController(StudentService studentService, StudentValidator studentValidator) {
        this.studentService = studentService;
        this.studentValidator = studentValidator;
    }

    @PostMapping("/students")
    public ResponseEntity<List<Student>> createStudents(@RequestBody List<Student> students) {
        studentValidator.validate(students);
        List<Student> updatedList = studentService.addAll(students);
        return ResponseEntity.ok(updatedList);
    }
}