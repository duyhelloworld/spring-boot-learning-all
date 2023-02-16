package com.example.crudeasy.model;

import java.sql.Date;

public class Student {
    private Long id;
    private String name;
    private Boolean sex;
    private Date dob;
    private Float height;
    private String mobileNumber;
    private String email;

    public Student(String name, Boolean sex, Date dob,  Float height, String mobileNumber, String email) {
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        this.height = height;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
    
    // Get From DB
    public Student(Long id, String name, Boolean sex, Date dob, Float height, String mobileNumber, String email) {
        this(name, sex, dob, height, mobileNumber, email);
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isSex() {
        return this.sex;
    }

    public Boolean getSex() {
        return this.sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public Float getHeight() {
        return this.height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
