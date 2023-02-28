package com.example.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public String getStudentById(@PathVariable("id") Long id) {
        System.out.println("\nMapped\n");
        return service.getStudentById(id).get().toString();
    }

    // @PostMapping(value = "/{id}", produces={"application/json"})
    // public Student demo(@PathVariable Long id) {
    //     return service.getStudentById(id).get();
    // }

    @PostMapping("/{id}")
    public boolean updateStudentName(@PathVariable Long id, @PathVariable String username) {
        return service.updateName(id, username);
    }

    @PostMapping("/{id}&/{name}")
    public boolean updateName(@PathVariable Long id, @PathVariable String name) {
        return service.updateName(id, name);
    }

    @PutMapping("/")
    public String registerNewStudent(@RequestBody Student student){
        return service.addNewStudent(student).toString();
    }

    // @DeleteMapping("/{id}")
    // public void removeStudent(@PathVariable Long[] ids) {
    //     service.remove(ids);
    // }
}