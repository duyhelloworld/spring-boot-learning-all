package com.duyhelloworld.rewritesinhvien.models;

import java.util.Set;

import jakarta.persistence.Column;

public class Student extends Person {

    private Set<Enrollment> enrolments;

    @Column(length = 20, nullable = false)
    private Enrollment managingClass;

    @Override 
    public String toString() {
        return "student : {" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", sex='" + isSex() + "'" +
                ", dob='" + getDob() + "'" +
                ", locations= {\n\twasBornIn=" + getAddresses().wasBornIn.toString() + "',\n\tcurrentLiveIn='"
                + getAddresses().currentLiveIn.toString() + "'" +
                ", email='" + getEmail() + "'" +
                ", numberPhone='" + getNumberPhone() + "'" +
                "}";
    }

}
