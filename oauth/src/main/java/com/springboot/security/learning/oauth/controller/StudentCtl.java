package com.springboot.security.learning.oauth.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.learning.oauth.model.Student;

@RestController
public class StudentCtl {
    private static final List<Student> STUDENTS = Arrays.asList(
        new Student(1, "Superman"),
        new Student(2, "Batman"),
        new Student(3, "WonderWoman"),
        new Student(4, "ShangChi")
    );

    @GetMapping(path = "/")
    public String home(){
        return "<h1>Home page</h1>";
    }

    @GetMapping(path = "/anonymous")
    public String anonymous(){
        return "<h1>Anonymous Page</h1>";
    }

    @GetMapping("/admin/student/all")
    private List<Student> getAllStudent(){
        return STUDENTS.subList(0, STUDENTS.size());
    }

    @GetMapping(path = "/admin/student/{id}")
    public Student getStudent(@PathVariable("id") Integer id){
        return STUDENTS.stream().filter(student -> id.equals(student.getId()))
        .findFirst().orElseThrow(() -> new IllegalStateException("Student " + id + " not found"));
    }

    @GetMapping("/user")
    public String userHome(Authentication authentication) {
        String username = authentication.getName().toLowerCase();
        String password = authentication.getCredentials().toString();
        System.out.println("Mapped to here");
        System.out.println(username + "\n" + password);
        return STUDENTS.stream().filter
            (student -> username.equals(student.getName().toLowerCase())
            &&
            password.equals(student.getName().toLowerCase()))
            .findFirst().get().toString();
    }

    // @GetMapping("/login")
    // public String getLogin(){
    //     return "You are logging in!";
    // }
}
