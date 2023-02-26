package com.example.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.repo.StudentRepo;

// @Component = @Service
@Service
public class StudentService {

    private final StudentRepo repo;

    @Autowired
    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        if (repo.existsById(id)) {
            return repo.getReferenceById(id);
        }
        return null;
    }
}
