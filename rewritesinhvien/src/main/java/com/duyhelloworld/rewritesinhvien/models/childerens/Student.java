package com.duyhelloworld.rewritesinhvien.models.childerens;

import java.util.Set;

import com.duyhelloworld.rewritesinhvien.models.abstraction.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
    @JoinColumn(name = "manage_class_id",
        referencedColumnName = "id",
        foreignKey = @ForeignKey(name = "FK_student_manageClass"))
    private ManageClass manageClass;

    @ManyToMany(mappedBy = "students", targetEntity = SubjectClass.class)
    private Set<SubjectClass> subjectClasses;

    @Override
    public String toString(){
        return "student : " + super.toString(); 
    }
}
