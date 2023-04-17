package com.duyhelloworld.rewritesinhvien.models.childerens;

import java.util.Set;

import com.duyhelloworld.rewritesinhvien.models.abstraction.Classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(name = "UK_manage_class_name", columnNames = "name")
})
public class ManageClass extends Classes {
    @OneToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @OneToMany(mappedBy = "manageClass")
    private Set<Student> studentsInManageClass;

    @Column(name = "name")
    private String name;
}
