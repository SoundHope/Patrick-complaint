package com.example.Patrickcomplaint;

import com.example.Patrickcomplaint.entity.Client;
import com.example.Patrickcomplaint.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PatrickComplaintApplication implements CommandLineRunner {

	private final ClientRepository clientRepository;

	public PatrickComplaintApplication(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(PatrickComplaintApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MockClientInDb();
	}

	private void MockClientInDb(){
		Client client1 = new Client("Patricio", "Ortega", "1752994952", "123");
		Client client2 = new Client("Ivanova", "Ortega", "1752994949", "123");
		List<Client> list = Arrays.asList(client1, client2);
		list.forEach(clientRepository::save);
	}
}
