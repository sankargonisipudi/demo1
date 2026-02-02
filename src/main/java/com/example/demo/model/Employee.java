package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Collection;


@Entity

public class Employee {

    private String firstName;


    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    private String lastName;
    private int age;

//    public Employee(String firstName, String lastName, int age, long id) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.id = id;
//    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Employee(String firstName, String lastName, int age,long id) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.id=id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
