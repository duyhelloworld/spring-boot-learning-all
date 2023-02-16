package com.example.crudeasy.api;

import java.sql.SQLException;
import java.util.List;

import com.example.crudeasy.dao.studentDAO;
import com.example.crudeasy.model.Student;

public class SaveStudent {
    // public boolean containStudent(Long id) {
        
    // }

    public Boolean save(Student std) throws SQLException {
        List<Student> students = studentDAO.getStudents();
        for (Student student : students) {
            if (std.getId() == student.getId()) {
                return false;
            }
        }


        return false;
    }
}
