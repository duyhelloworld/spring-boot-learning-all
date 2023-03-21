package com.example.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.example.studentmanagementsystem.model.Student;

public interface IService {
    public List<Student> getAllStudent();
    
    public Optional<Student> getStudentById(Long id);

    public List<Student> getStudentByName(String name);

    public Student updateStudentInfo(Long id, Student student);

    public Student addStudent(Student student);
    
    public void remove(Long id);
}
