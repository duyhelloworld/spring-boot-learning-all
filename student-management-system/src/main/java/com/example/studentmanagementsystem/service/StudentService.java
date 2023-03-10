package com.example.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Student> getStudentById(Long id) {
        if (repo.existsById(id)) {
            System.out.println("\nExist " + id + "\n");
            Student result = repo.getReferenceById(id);
            Optional<Student> opt = Optional.of(result);
            return opt;
        }
        System.out.println("Not exist " + id);
        return null;
    }
    
    public List<Student> getStudentByName(String name) {
        return repo.findByName(name);
    }
    
    public Student updateStudentInfo(Long id, Student student) {
        if (id != student.getId()) {
            throw new IllegalArgumentException("BAD Request!");
        }
        if (!repo.existsById(id)) {
            return null;
        }
        repo.save(student);
        return student;
    }


    public Student addNewStudent(Student student) {
        if (repo.findByEmail(student.getEmail()).isPresent()) {
            throw new IllegalArgumentException("this email has signed up");
        }
        repo.saveAndFlush(student);
        return student;
    }

    public void remove(Long id){
        if (getStudentById(id).isEmpty()) {
            throw new IllegalArgumentException("Not found " + id);
        }
        repo.deleteById(id);
    }
}
