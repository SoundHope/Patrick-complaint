package com.example.Patrickcomplaint.repository;

import com.example.Patrickcomplaint.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByDni(String dni);
    Optional<Client> findByDniAndPassword(String dni, String Password);
}
