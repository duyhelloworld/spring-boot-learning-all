package com.duyhelloworld.rewritesinhvien.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.duyhelloworld.rewritesinhvien.models.childerens.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query("SELECT s from Student s WHERE s.fullName LIKE CONCAT('%', :fullName, '%')")
    List<Student> getStudentsByName(@Param("fullName") String fullName);

    @Query("SELECT s from Student s WHERE s.email = ?1")
    Optional<Student> getStudentsByEmail(String email);

    @Query("SELECT s from Student s WHERE s.numberPhone LIKE CONCAT('%', ?1)")
    List<Student> getNumberPhoneLike(String numberPhone);

    // TODO
    Set<Student> getStudentsByManageClass(Integer Mclass_id);

    // TODO
    Set<Student> getStudentsBySubjectClass(Integer Sclass_id);
}
