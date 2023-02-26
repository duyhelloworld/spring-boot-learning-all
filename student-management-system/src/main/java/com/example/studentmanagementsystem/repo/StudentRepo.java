package com.example.studentmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentmanagementsystem.model.Student;

@Repository
// Data access layer
public interface StudentRepo extends JpaRepository<Student, Long>{
    
}
