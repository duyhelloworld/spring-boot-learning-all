package com.example.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagementsystem.model.Student;
/*
 * @GetMapping("/")
    public String hello_world() {
        return "<h1>Hello World</h1>";
    }
    @GetMapping("/json-example")
    public List<String> jsonExample() {
        return List.of("Title", "Content", "Footer", "About Us");
     }
 */
import com.example.studentmanagementsystem.service.StudentService;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    // DI - Constructor
    private final StudentService service;

    @Autowired(required = true)
    public StudentController(StudentService service) {
        this.service = service;
    }

    // DI - Setter
    /*
     * private StudentService service;
     * public void setStudentService(StudentService service) {
     * this.service = service;
     * }
     */

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return service.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return service.getById(Long.parseLong(id));
    }
    

}
