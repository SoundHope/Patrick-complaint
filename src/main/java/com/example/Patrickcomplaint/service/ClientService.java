package com.example.Patrickcomplaint.service;

import com.example.Patrickcomplaint.entity.Client;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ClientService {
    Optional<Client> getClient(String dni);
    Optional<Client> login(String dni, String password);
}
