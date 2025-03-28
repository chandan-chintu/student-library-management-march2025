package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

@Entity
@Table(name = "book")
public class Book {
    //id, title, pages, publisher name, publisedDate, edition,  category, price, rackNo, availability(true or false)

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="pages", nullable = false)
    private int pages;

    @Column(name="publisher_name", nullable = false)
    private String publisherName;

    @Column(name="published_date", nullable = false)
    private String publishedDate;

    @Column(name="edition", nullable = false)
    private String edition;

    @Column(name="category", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(name="price", nullable = false)
    private double price;

    @Column(name="rack_no", nullable = false)
    private String rackNo;

    @Column(name="availability", nullable = false)
    private boolean availability;
}
