package com.duyhelloworld.rewritesinhvien.interfaces;

import java.util.List;
import java.util.Set;

import com.duyhelloworld.rewritesinhvien.models.childerens.Student;

public interface IStudent {
    public Set<Student> getAll();

    public Set<Student> getAllByManageClass(Integer Mclass_id);
    
    public Set<Student> getAllBySubjectClass(Integer Sclass_Id);

    public Student getById(Integer id);

    public List<Student> getByName(String name);
    
    public Student getByEmail(String email);

    public List<Student> getByNumberPhone(String numberPhone);
}
