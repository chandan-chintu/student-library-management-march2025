package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    @Column(name="transaction_date", nullable = false)
    private Date transactionDate;

    @Column(name="fine")
    private double fine;

    @Column(name="due_date", nullable = false)
    private String dueDate;

    @Column(name="transaction_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;
}
