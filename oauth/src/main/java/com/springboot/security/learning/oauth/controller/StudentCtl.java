package com.springboot.security.learning.oauth.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.learning.oauth.model.Student;

@RestController
@RequestMapping("/api/v1/student")
public class StudentCtl {
    private static final List<Student> STUDENTS = Arrays.asList(
        new Student(1, "Superman"),
        new Student(2, "Batman"),
        new Student(3, "WonderWoman"),
        new Student(4, "ShangChi")
    );

    @GetMapping(path = {"/", "/home"})
    public String home(){
        return "<h1>Home page</h1>"
                + "<h3>We have role Admin + User!</h3>";
    }

    @GetMapping(path = "/anonymous")
    public ResponseEntity<String> anonymous(){
        return new ResponseEntity<String>("<h1>Anonymous Page</h1>", HttpStatusCode.valueOf(200));
    }

    @GetMapping("/admin/student/all")
    private List<Student> getAllStudent(){
        return STUDENTS.subList(0, STUDENTS.size());
    }

    @GetMapping(path = "/admin/student/{id}")
    private Student getStudent(@PathVariable("id") Integer id){
        return STUDENTS.stream()
        .filter(student -> id.equals(student.getId()))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Student " + id + " not found"));
    }

    @GetMapping("/user")
    private ResponseEntity<String> userHome(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println("Mapped to /user");
        System.out.println(username + "\n" + password);
        return ResponseEntity.ok("User logined");
    }

    // @GetMapping("/login")
    // public String getLogin(){
    //     return "You are logging in!";
    // }


}
