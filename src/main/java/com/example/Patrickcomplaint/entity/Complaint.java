package com.example.Patrickcomplaint.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Client client;

    public Complaint() {
    }

    public Complaint(String type, String detail, Client client) {
        this.type = type;
        this.detail = detail;
        this.client = client;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", detail='" + detail + '\'' +
                ", client=" + client +
                '}';
    }
}
