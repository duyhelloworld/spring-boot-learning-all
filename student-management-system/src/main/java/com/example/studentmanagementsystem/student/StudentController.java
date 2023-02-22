package com.example.studentmanagementsystem.student;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagementsystem.model.Student;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(name = "GET")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }


	// @GetMapping("/")
    // public String hello_world() {
    // return "<h1>Hello World</h1>";
    // }

    // @GetMapping("/json-example")
    // public List<String> jsonExample() {
    // return List.of("Title", "Content", "Footer", "About Us");
    // }

    // @GetMapping("/student")
    // public List<Student> Students() {
    // return List.of(
    // new Student("Duy",
    // 19,
    // LocalDate.of(2003, Month.DECEMBER, 9),
    // "codedao")
    // );
    // }
}
