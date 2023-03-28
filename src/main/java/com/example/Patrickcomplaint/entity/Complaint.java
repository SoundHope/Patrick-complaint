package com.example.Patrickcomplaint.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "complaint")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(length = 100)
    private String type;
    @Column(length = 255)
    private String detail;

    @ManyToOne
    private Client client;

}
