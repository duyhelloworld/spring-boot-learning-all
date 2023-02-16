package com.example.crudeasy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.crudeasy.model.Student;

public class studentDAO {

    public static List<Student> getStudents() throws SQLException{
        List<Student> list = new ArrayList<Student>();
        Connection conn = GetConnection.getConnection();
        String command = "SELECT * FROM `student`.student";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(command);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student std = new Student(rs.getLong("id"), rs.getString("name"), rs.getBoolean("sex"),
                        rs.getDate("dob"), rs.getFloat("height"), rs.getString("mobileNumber"), rs.getString("email"));
                list.add(std);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return list;
    }

    public static Student getStudent(Long id) throws SQLException{
        Connection conn = GetConnection.getConnection();
        String command = "SELECT * FROM `student`.student WHERE id = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(command);
            pstm.setString(1, id.toString());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student std = new Student(rs.getLong("id"), rs.getString("name"), rs.getBoolean("sex"),
                        rs.getDate("dob"), rs.getFloat("height"), rs.getString("mobileNumber"), rs.getString("email"));
                return std;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return null;
    }
}
