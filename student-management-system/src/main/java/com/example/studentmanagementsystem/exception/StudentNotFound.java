package com.example.studentmanagementsystem.exception;

public class StudentNotFound extends Exception {
    public StudentNotFound(Long id) {
        super("\nNot found " + id.toString());
    }

    public StudentNotFound(String name) {
        super("Not found " + name);
    }

    public StudentNotFound(String name, String email) {
        super("Not found " + email);
    }
}
