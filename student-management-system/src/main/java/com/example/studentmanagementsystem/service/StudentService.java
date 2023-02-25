package com.example.studentmanagementsystem.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studentmanagementsystem.model.Student;

// @Component = @Service
@Service
public class StudentService {
    public List<Student> getAllStudent() {
        return List.of(new Student(
                "unknown",
                18,
                LocalDate.of(2004, Month.AUGUST, 10),
                1.75f,
                "unknown@gmail.com",
                ""));
    }
}
