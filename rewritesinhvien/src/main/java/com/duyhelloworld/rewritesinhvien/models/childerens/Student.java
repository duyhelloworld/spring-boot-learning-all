package com.duyhelloworld.rewritesinhvien.models.childerens;

import com.duyhelloworld.rewritesinhvien.models.abstraction.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = "number_phone", name = "UK_number_phone"),
    @UniqueConstraint(columnNames = "email", name = "UK_email")
})
public class Student extends Person {
    @ManyToOne
    @JoinColumn(name = "manage_class_id")
    private ManageClass manageClass;

    @ManyToOne
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;

    @Override
    public String toString(){
        return "student : " + super.toString(); 
    }
}
