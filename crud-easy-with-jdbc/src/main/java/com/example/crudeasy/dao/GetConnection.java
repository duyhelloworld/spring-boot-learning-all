package com.example.crudeasy.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
    private static Connection conn;
    
    private static Connection getConn() {
        return conn;
    }

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/student";
        String usr = "duyaiti";
        String passwd = "12345678";
        Connection conn = GetConnection.getConn();
        try {
            int retry = 0;
                do {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(url, usr, passwd);
                    retry++;
                System.out.println("Connected");
                } while (conn != null || retry > 3);
            } catch (Exception e) {
                e.getMessage();
            }
            return conn;
    }
}
