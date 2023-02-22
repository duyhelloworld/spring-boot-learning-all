package com.example.studentmanagementsystem.student;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studentmanagementsystem.model.Student;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student("Pham Duc Duy",
                19,
                LocalDate.of(2003, Month.DECEMBER, 9),
                new BigDecimal(1.75),
                        "codedaovoiduy", 
                        ""));
    }
}
