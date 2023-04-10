package com.duyhelloworld.rewritesinhvien.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@MappedSuperclass
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "number_phone"))
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    @Column(length = 200)
    private Name name;

    private Boolean sex;

    @Embeddable
    public class Name {
        String firstName;
        String middleName;
        String lastName;

        public Name(String fullName){
            String[] nameDivided = fullName.split(" ");
            this.firstName = nameDivided[0];
            this.lastName = nameDivided[nameDivided.length - 1];
            this.middleName = String.join(" ", Arrays.copyOfRange(nameDivided, 1, nameDivided.length - 1));
        }

        @Override
        public String toString() {
            return firstName + " " + middleName + " " + lastName;
        }
    }

    @Temporal(TemporalType.DATE)
    private LocalDate dob;

    @Embedded
    private Address addresses;

    @Embeddable
    public class Address {
        @Enumerated(EnumType.STRING)
        Map<InfoOfAddress, String> currentLiveIn;
        @Enumerated(EnumType.STRING)
        Map<InfoOfAddress, String> wasBornIn;

        @Override
        public String toString() {
            return "currentLiveIn=" + currentLiveIn.values() + ",\nwasBornIn=" + wasBornIn.values();
        }
    }

    @Column(length = 100)
    private String email;

    @Column(length = 10, unique = true, name = "number_phone")
    private String numberPhone;





    public Person() {
    }

    public Person(Name name, Boolean sex, LocalDate dob, Address addresses, String email, String numberPhone) {
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        this.addresses = addresses;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Name getName() {
        return this.name;
    }

    public void setName(Name name) {
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

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Address getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        String regex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";
        try {
            if(!email.matches(regex)) {
                throw new IllegalArgumentException("Wrong email format");
            }
            this.email = email;
        } 
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public String getNumberPhone() {
        return this.numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        String regex = "^0\\d{9}$";
        if (!numberPhone.matches(regex)) {
            throw new NumberFormatException("Invalid number phone format");
        }
        this.numberPhone = numberPhone;
    }

    public Person name(Name name) {
        setName(name);
        return this;
    }

    public Person sex(Boolean sex) {
        setSex(sex);
        return this;
    }

    public Person dob(LocalDate dob) {
        setDob(dob);
        return this;
    }

    public Person locations(Address addresses) {
        setAddresses(addresses);
        return this;
    }

    public Person email(String email) {
        setEmail(email);
        return this;
    }

    public Person numberPhone(String numberPhone) {
        setNumberPhone(numberPhone);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(sex, person.sex) && Objects.equals(dob, person.dob) && Objects.equals(email, person.email) && Objects.equals(numberPhone, person.numberPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, numberPhone);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", sex='" + isSex() + "'" +
            ", dob='" + getDob() + "'" +
            ", locations= {\n\twasBorn=" + getAddresses().wasBornIn.toString() + "',\n\tcurrentLiving='" + getAddresses().currentLiveIn.toString() + "'" +
            ", email='" + getEmail() + "'" +
            ", numberPhone='" + getNumberPhone() + "'" +
            "}";
    }
}