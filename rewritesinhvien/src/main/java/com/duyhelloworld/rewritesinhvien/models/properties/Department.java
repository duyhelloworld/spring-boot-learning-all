package com.duyhelloworld.rewritesinhvien.models.properties;

import java.util.Set;

import com.duyhelloworld.rewritesinhvien.models.childerens.SubjectClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
    @Id
    @Column(length = 5)
    private String roomName;

    @OneToMany(mappedBy = "department")
    private Set<SubjectClass> subjectClasses;

    @Column(length = 100, nullable = false)
    private String location;
}
