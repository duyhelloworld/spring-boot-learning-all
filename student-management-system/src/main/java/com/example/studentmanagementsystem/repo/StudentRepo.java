package com.example.studentmanagementsystem.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.studentmanagementsystem.model.Student;

@Repository
// Data access layer
public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query(
        nativeQuery = false,
        // value = "SELECT s FROM Student s WHERE s.email = :email"
        value = "SELECT s FROM Student s WHERE s.email = ?1"
        )
    // Optional<Student> findByEmail(@Param("email") String email);
    Optional<Student> findByEmail(String email);

    @Query(value = "SELECT s FROM Student s WHERE s.name LIKE CONCAT('%', ?1, '%')")
    List<Student> findByName(String name);
}