package com.melo567.presence.check.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
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
}
