package com.example.studentmanagementsystem.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student("Pham Duc Duy",
                        19,
                        LocalDate.of(2003, Month.DECEMBER, 9),
                        "codedaovoiduy"));
    }
}
