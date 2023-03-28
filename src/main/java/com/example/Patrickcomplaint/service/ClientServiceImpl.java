package com.example.Patrickcomplaint.service;

import com.example.Patrickcomplaint.entity.Client;
import com.example.Patrickcomplaint.repository.ClientRepository;

import java.util.Optional;

public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> getClient(String dni) {
        return clientRepository.findByDni(dni);
    }

    public Optional<Client> login(String dni, String password) {
        return clientRepository.findByDniAndPassword(dni, password);
    }
}
