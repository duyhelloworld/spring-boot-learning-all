package com.duyhelloworld.rewritesinhvien.models.childerens;

import java.util.Set;

import com.duyhelloworld.rewritesinhvien.models.abstraction.Classes;
import com.duyhelloworld.rewritesinhvien.models.properties.Subject;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class SubjectClass extends Classes {

    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "subjectClass")
    private Set<Student> studentsInSubjectClass;
}
