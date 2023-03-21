package com.example.studentmanagementsystem.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.repo.StudentRepo;

import jakarta.transaction.Transactional;

// @Component = @Service + readability
@Service
public class StudentService {

    private final StudentRepo repo;

    @Autowired(required = true)
    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    // Create
    public Student addStudent(Student student) {
        if (repo.findByEmail(student.getEmail()).isPresent()) {
            throw new IllegalStateException("This email has signed up");
        }
        repo.saveAndFlush(student);
        return student;
    }

    // Read

    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Not found " + id);
        }
        System.out.println("\nExist " + id + "\n");
        Student result = repo.getReferenceById(id);
        Optional<Student> opt = Optional.of(result);
        return opt;
    }

    public List<Student> getStudentByName(String name) {
        return repo.findByName(name);
    }

    // Update

    // public Student updateStudentInfo(Long id, Student student) {
    //     if (id != student.getId()) {
    //         throw new IllegalArgumentException("BAD Request!!!");
    //     }
    //     if (!repo.existsById(id)) {
    //         return null;
    //     }
    //     repo.save(student);
    //     return student;
    // }

    @Transactional
    public void updateStudentInfo(Long id, String name, String email) {
        Student student = repo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Not found " + id));
        
        if (name != null
                && name.length() > 0
                && !Objects.equals(name, student.getName())) {
            student.setName(name);
        }
        if (email != null
                && email.length() > 0
                && !Objects.equals(email, student.getEmail())) {
            if (repo.findByEmail(email).isPresent()) {
                throw new IllegalArgumentException("Not found " + email);
            }
            student.setEmail(email);
        }
    }
    // Delete

    public void removeById(Long id) {
        boolean exist = repo.existsById(id);
        if (!exist) {
            throw new IllegalArgumentException("Not found " + id);
        }
        repo.deleteById(id);
    }
}
