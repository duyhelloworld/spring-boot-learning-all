package com.example.studentmanagementsystem.exception;

public class StudentNotFound extends Exception {
    public StudentNotFound(Long id) {
        super("\nNot found " + id.toString());
    }
}
