package com.example.studentmanagementsystem.model;

// import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
// import jakarta.persistence.Lob;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// import jakarta.persistence.SequenceGenerator;

@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(name = "student_email_unique", columnNames = "email" /* columnName used to map with @Column below */ )
    }
)


public class Student{
    @Id
    @GeneratedValue(generator = "student_sq", strategy = GenerationType.SEQUENCE /* Sequencing depend on DBMS. MySQL - auto */)

    // @SequenceGenerator(
    //         name = "student_sq", /* SequenGen(name) = GeneratedValue(generator) */
    //         allocationSize = 1,
    //         sequenceName = "student_sq",
    //         initialValue = 1
    // )

    // @Column(updatable = false, scale = 0, precision = 7) /* Only work when use BigDecimal */
    private int id;

    /**
     * Sequence is some column auto-increment
     * In MYSQL, it is AUTO_INCREMENT constraint. It can {
     *                  "update current ID by every greater ID which isn't existing in table"
     *                  "Change id to another id which not assigned"         
     * }
     */
    
    @Column(length = 30, nullable = false)
    private String name;
    
    @Column(nullable = true)
    private int age;
    
    /**
     * 123.45
     * precison : 5 (5 digit != 0.)       10 -> 2
     * scale : 2 (2 number after .)       10 -> 0
     */

    // @Column(scale = 2, precision = 3)
    // private BigDecimal height;

    @Column
    private float height;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(columnDefinition = "TEXT")
    // or
    // @Lob
    private String definition;
        
    public Student(String name,
                int age,
                LocalDate dob,
                float height,
                String email, String definition) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.height = height;
        this.definition = definition;
        this.email = email;
    }


    // BoilerPlate Code
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getDefinition() {
        return this.definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'\n" +
            ", name='" + getName() + "'\n" +
            ", age='" + getAge() + "'\n" +
                ", dob='" + getDob() + "'\n" +
                ", height='" + getHeight() + "'\n" +
                ", email='" + getEmail() + "'\n" +
                ", definition='" + getDefinition() + "'\n" +
                "}";
    }
    

}
