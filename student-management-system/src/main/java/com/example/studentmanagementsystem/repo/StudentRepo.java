package com.example.studentmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementsystem.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{
    
}
