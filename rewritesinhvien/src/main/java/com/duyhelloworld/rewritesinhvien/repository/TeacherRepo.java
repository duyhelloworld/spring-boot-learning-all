package com.duyhelloworld.rewritesinhvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.duyhelloworld.rewritesinhvien.models.childerens.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer>{
    @Query("SELECT t from Teacher t WHERE t.fullName LIKE CONCAT('%', :fullName, '%')")
    List<Teacher> getTeachersByName(@Param("fullName") String fullName);

    @Query("SELECT t from Teacher t WHERE t.email = ?1")
    List<Teacher> getTeachersByEmail(String email);

    @Query("SELECT t.numberPhone from Teacher t WHERE t.numberPhone LIKE CONCAT('%', ?1)")
    List<String> getNumberPhoneLike(String numberPhone);

    @Query("SELECT mc.name FROM ManageClass mc WHERE mc.teacher_id = :id")
    String getManagingClass(@Param("id") Integer id);
}
