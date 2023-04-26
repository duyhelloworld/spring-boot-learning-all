package com.duyhelloworld.rewritesinhvien.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyhelloworld.rewritesinhvien.exception.StudentNotFoundException;
import com.duyhelloworld.rewritesinhvien.interfaces.IStudent;
import com.duyhelloworld.rewritesinhvien.models.childerens.Student;
import com.duyhelloworld.rewritesinhvien.repository.StudentRepo;

@Service
public class SubjectService implements IStudent {
    private StudentRepo studentRepo;
    
    @Autowired
    public SubjectService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @Override
    public Set<Student> getAll() {
        return new HashSet<Student>(studentRepo.findAll());
    }
    
    @Override
    public Set<Student> getAllByManageClass(Integer Mclass_id) {
        Set<Student> result = studentRepo.getStudentsByManageClass(Mclass_id);
        return result;
    }

    @Override
    public Set<Student> getAllBySubjectClass(Integer Sclass_id) {
        Set<Student> result = studentRepo.getStudentsBySubjectClass(Sclass_id);
        return result;
    }

    @Override
    public Student getById(Integer id) {
        try {
            Optional<Student> std = studentRepo.findById(id);
            if(std.isPresent()) {
                throw new StudentNotFoundException("Id " + id + " not exist");
            }
            return std.get();
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Student> getByName(String name) {
        List<Student> students = studentRepo.getStudentsByName(name);
        return students;
    }

    @Override
    public Student getByEmail(String email) {
        try {
            Optional<Student> std = studentRepo.getStudentsByEmail(email);
            if (std.isPresent()) {
                throw new StudentNotFoundException("Email " +  email+ " not exist");
            }
            return std.get();
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Student> getByNumberPhone(String numberPhone) {
        List<Student> students = studentRepo.getNumberPhoneLike(numberPhone);
        return students;
    }
}