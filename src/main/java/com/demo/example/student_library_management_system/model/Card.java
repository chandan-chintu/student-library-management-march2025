package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="card")
public class Card {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="card_status",  nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @Column(name="blood_group", nullable = false)
    private String bloodGroup;

    @Column(name="created_date",  nullable = false)
    @CreationTimestamp // when new card is creating automatically date and time is added
    private Date createdDate;

    @Column(name="updated_date",  nullable = false)
    @UpdateTimestamp // when new card is updating automatically date and time is added
    private Date updatedDate;

}
