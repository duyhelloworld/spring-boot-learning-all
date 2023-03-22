package com.example.crudeasy.api;

import java.sql.Connection;
import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateStudent {
    static Connection conn = null;

    public static Boolean isConnected() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String usr = "duyaiti";
            String passwd = "12345678";
            String url = "jdbc:mysql://localhost:3306/student";

            conn = DriverManager.getConnection(url, usr, passwd);
        } catch (Exception e) {
            e.getMessage();
        }
        if (conn != null) {
            return true;
        } else
            return false;
    }

    @PutMapping("/student/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody String data) {
        // return "id = " + id.toString();
        while (isConnected()) {
            // PreparedStatement pstm = null;
            String command = "UPDATE student.`student` SET " + id.toString();
            return command;
        }
        return data;

    }

}
