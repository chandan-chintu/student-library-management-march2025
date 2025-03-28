package com.demo.example.student_library_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Column(name="id")
    @Id  // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="mobile", nullable = false)
    private String mobile;

    @Column(name="email", nullable = false, unique=true)
    private String email;

    @Column(name="dept", nullable = false)
    private String dept;

    @Column(name="sem", nullable = false)
    private String sem;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="dob", nullable = false)
    private String dob;

    @Column(name="gender", nullable = false)
    private String gender;

    @Column(name="section", nullable = false)
    private String section;



}
