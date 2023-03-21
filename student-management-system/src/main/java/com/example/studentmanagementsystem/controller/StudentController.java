package com.example.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.service.StudentService;

@RestController
@RequestMapping(path = "/api/v1/student")
@CrossOrigin(origins = "http://localhost:5500")
public class StudentController {

    // DI - Constructor
    private StudentService service;

    // @Autowired
    // public StudentController(StudentService service) {
    //     this.service = service;
    // }
    // DI - Setter
    
    @Autowired
    public void setStudentService(StudentService service) {
        this.service = service;
    }
    
    @GetMapping(value = { "" })
    public List<Student> getAllStudents() {
        return service.getAllStudent();
    }

    @GetMapping(path = "/{id}")
    public String getStudentById(@PathVariable("id") Long id) {
        return service.getStudentById(id).get().toString();
    }

    @GetMapping(value = "/")
    public String getStudentByName(@RequestParam("name") String name) {
        return service.getStudentByName(name).toString();
    }

    @PostMapping(path = { "/", "" }, produces = { "text/plain", "application/json" })
    public String registerNewStudent(@RequestBody(required = true) Student student) {
        return service.addStudent(student).toString();
    }

    // @PutMapping(value = "/{studentId}", produces = "application/json")
    // public void updateStudentInfo(@PathVariable(value = "studentId") Long id, @RequestBody(required = true) Student student) {
    //     service.updateStudentInfo(id, student);
    // }

    @PutMapping("/{id}")
    public void updateStudentInfo(
            @PathVariable("id") Long id,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "", required = true) String email) {
        service.updateStudentInfo(id, name, email);
    }

    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable("id") Long id) {
        service.removeById(id);
    }
}