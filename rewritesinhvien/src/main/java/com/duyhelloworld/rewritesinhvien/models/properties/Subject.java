package com.duyhelloworld.rewritesinhvien.models.properties;

import java.util.List;

import com.duyhelloworld.rewritesinhvien.models.childerens.SubjectClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(
    name = "UK_subject_name",
    columnNames = "name"))
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private boolean isObligatory; // bat buoc
    
    @Column
    private boolean isPrerequisite; // tien quyet   

    @OneToMany(mappedBy = "subject")
    private List<SubjectClass> subjectClasses;
}
