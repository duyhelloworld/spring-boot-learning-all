package com.duyhelloworld.rewritesinhvien.models.abstraction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.duyhelloworld.rewritesinhvien.models.properties.InfoOfAddress;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;


@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    @Transient
    private Name name ;

    @Column(length = 200, name = "full_name")
    private String fullName = (name != null) ? name.toString() : "";

    private Boolean sex;

    @Embeddable
    public class Name {
        @Column(length = 30)
        String firstName;
        @Column(length = 30)
        String middleName;
        @Column(length = 30)
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

    
    @Column(name = "was_born_in", length = 100)
    private String wasBornIn;
    
    @Column(name = "current_live_in", length = 100)
    private String currentLiveIn;

    @Transient
    private Map<InfoOfAddress, String> M_currentLiveIn = new HashMap<>();
    @Transient
    private Map<InfoOfAddress, String> M_wasBornIn = new HashMap<>();

    @Column(length = 100, name = "email")
    private String email;

    @Column(length = 10, name = "number_phone")
    private String numberPhone;

    public Person() {
    }

    public Person(Name name, Boolean sex, LocalDate dob, Map<InfoOfAddress, String> M_wasBornIn, Map<InfoOfAddress, String> M_currentLiveIn, String email, String numberPhone) {
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        if (M_wasBornIn != null) {
            this.wasBornIn = M_wasBornIn.values().toString().split(", ").toString();
        }
        if (M_currentLiveIn != null) {
            this.currentLiveIn = M_currentLiveIn.values().toString().split(", ").toString();
        }
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

    public Map<InfoOfAddress,String> getMapCurrentLiveIn() {
        return this.M_currentLiveIn;
    }

    public Map<InfoOfAddress, String> getMapWasBornIn() {
        return this.M_wasBornIn;
    }

    public void setCurrentLiveIn(Map<InfoOfAddress, String> currentLiveIn) {
        this.M_currentLiveIn = currentLiveIn;
    }
    
    public void setWasBornIn(Map<InfoOfAddress, String> wasBornIn) {
        this.M_wasBornIn = wasBornIn;
    }

    public void setWasBornIn(String houseNumber, String road, String street, String commune, String district, String province, String city) {
        this.M_wasBornIn.put(InfoOfAddress.HOUSE_NUMBER, houseNumber);
        this.M_wasBornIn.put(InfoOfAddress.ROAD, road);
        this.M_wasBornIn.put(InfoOfAddress.STREET, street);
        this.M_wasBornIn.put(InfoOfAddress.COMMUNE, commune);
        this.M_wasBornIn.put(InfoOfAddress.DISTRICT, district);
        this.M_wasBornIn.put(InfoOfAddress.PROVINCE, province);
        this.M_wasBornIn.put(InfoOfAddress.CITY, city);
    }
    
    public void setCurrentLiveIn(String houseNumber, String road, String street, String commune, String district,
            String province) {
        this.M_currentLiveIn.put(InfoOfAddress.HOUSE_NUMBER, houseNumber);
        this.M_currentLiveIn.put(InfoOfAddress.ROAD, road);
        this.M_currentLiveIn.put(InfoOfAddress.STREET, street);
        this.M_currentLiveIn.put(InfoOfAddress.COMMUNE, commune);
        this.M_currentLiveIn.put(InfoOfAddress.DISTRICT, district);
        this.M_currentLiveIn.put(InfoOfAddress.PROVINCE, province);
    }

    
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getWasBornIn() {
        return this.wasBornIn;
    }

    public String getCurrentLiveIn() {
        return this.currentLiveIn;
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

    public Person currentLiveIn(Map<InfoOfAddress,String> currentLiveIn) {
        setCurrentLiveIn(currentLiveIn);
        return this;
    }

    public Person wasBornIn(Map<InfoOfAddress,String> wasBornIn) {
        setWasBornIn(wasBornIn);
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
            ", locations= {\n\twasBorn=" + getWasBornIn() + "',\n\tcurrentLiving='" + getCurrentLiveIn() + "'" +
            ", email='" + getEmail() + "'" +
            ", numberPhone='" + getNumberPhone() + "'" +
            "}";
    }
}