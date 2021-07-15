package com.melo567.presence.check.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "employee_id")
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("age")
    private int age;

    @Column(name = "email", unique = true)
    @JsonProperty("email")
    private String email;

    @JsonProperty("phone1")
    @JsonIgnore
    private String phone1;

    @JsonProperty("phone2")
    @JsonIgnore
    private String phone2;

    @JsonProperty("phone3")
    @JsonIgnore
    private String phone3;

    @Transient
    @JsonProperty("phones")
    private List<String> phones;

    @JsonProperty("avatar")
    private String avatar;

    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<Experience> experiences;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public List<String> getPhones() {
        List<String> phones = new ArrayList<>();
        phones.add(getPhone1());
        if (getPhone2() != null) phones.add(getPhone2());
        if (getPhone3() != null) phones.add(getPhone3());
        return phones;
    }

    public void setPhones(List<String> phones) {

        this.phones = phones;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
}
