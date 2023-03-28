package com.example.Patrickcomplaint.configuration;

import com.example.Patrickcomplaint.repository.ClientRepository;
import com.example.Patrickcomplaint.repository.ComplaintRepository;
import com.example.Patrickcomplaint.service.ClientService;
import com.example.Patrickcomplaint.service.ClientServiceImpl;
import com.example.Patrickcomplaint.service.ComplaintService;
import com.example.Patrickcomplaint.service.ComplaintServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
public class GeneralConfig {
    @Bean
    ClientService clientService(ClientRepository clientRepository) {

        return new ClientServiceImpl(clientRepository);
    }

    @Bean
    ComplaintService complaintService(ComplaintRepository complaintRepository){
        return new ComplaintServiceImpl(complaintRepository);
    }
}

