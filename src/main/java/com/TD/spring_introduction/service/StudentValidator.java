package com.TD.spring_introduction.service;

import com.TD.spring_introduction.Entity.Student;
import com.TD.spring_introduction.Exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentValidator {
    public void validate (List<Student> students){
        for (Student s : students){
            if (s.getReference() == null || s.getReference().isBlank()){
                throw new BadRequestException("NewStudent.reference cannot be null");
            }
            if (s.getName() == null || s.getName().isBlank()){
                throw new BadRequestException("NewStudent.name cannot be null");
            }
            if (s.getLastName() == null || s.getLastName().isBlank()){
                throw new BadRequestException(("NewStudent.lasName cannont be null"));
            }
        }
    }
}
