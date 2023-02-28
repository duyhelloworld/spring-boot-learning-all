package com.example.studentmanagementsystem.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.studentmanagementsystem.model.Student;

// @EnableJpaRepositories
@Repository
// Data access layer
public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query(
            nativeQuery = true,
            // value = "SELECT s FROM student s WHERE s.email = ?1"
            value = "SELECT s Student s WHERE s.email = :email"
        )
        Optional<Student> findByEmail(
                // String email
                @Param("email") String email
        );

    @Query("SELECT name FROM Student s WHERE s.name LIKE %?1%")
    List<Student> findByName(String name);
}