package com.duyhelloworld.rewritesinhvien.models.childerens;

import java.util.Set;

import com.duyhelloworld.rewritesinhvien.models.abstraction.Classes;
import com.duyhelloworld.rewritesinhvien.models.properties.Department;
import com.duyhelloworld.rewritesinhvien.models.properties.Subject;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class SubjectClass extends Classes {

    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToMany
    @JoinTable(name = "subjectClass_teacher",
        joinColumns = @JoinColumn(name = "subject_class_id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"), 
        foreignKey = @ForeignKey(name = "FK_subjectClass_teacher"))
    private Set<Teacher> teachers;

    @ManyToMany
    @JoinTable(name = "subjectClass_student",
        joinColumns = @JoinColumn(name = "subject_class_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
        foreignKey = @ForeignKey(name = "FK_subjectClass_student"))
    private Set<Student> students;

    @ManyToOne
    @JoinColumn(name = "department_id", 
        referencedColumnName = "roomName",
        foreignKey = @ForeignKey(name = "FK_subjectClass_department"))
    private Department department;
}
