package com.example.Patrickcomplaint.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(length = 255)
    private String name;
    @Column(length = 50)
    private String last_name;
    @Column(length = 50, unique = true)
    private String dni;
    @Column(length = 50)
    private String password;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Complaint> complaints = new ArrayList<>();

    public Client() {
    }

    public Client(String name, String last_name, String dni, String password) {
        this.name = name;
        this.last_name = last_name;
        this.dni = dni;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
