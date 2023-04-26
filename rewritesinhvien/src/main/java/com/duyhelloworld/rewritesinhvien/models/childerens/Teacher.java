package com.duyhelloworld.rewritesinhvien.models.childerens;

import java.util.Set;

import com.duyhelloworld.rewritesinhvien.models.abstraction.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Teacher extends Person {
    @ManyToMany(mappedBy = "teachers", targetEntity = SubjectClass.class)
    private Set<SubjectClass> subjectClasses;
}