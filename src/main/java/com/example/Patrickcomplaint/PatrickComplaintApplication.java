package com.example.Patrickcomplaint;

import com.example.Patrickcomplaint.entity.Client;
import com.example.Patrickcomplaint.repository.ClientRepository;
import com.example.Patrickcomplaint.security.SecSecurityConfig;
import jakarta.servlet.ServletContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PatrickComplaintApplication implements CommandLineRunner, WebApplicationInitializer {

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

	@Override
	public void onStartup(ServletContext sc) {

		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.register(SecSecurityConfig.class);

		sc.addListener(new ContextLoaderListener(root));

		sc.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
				.addMappingForUrlPatterns(null, false, "/*");
	}

	private void MockClientInDb(){
		Client client1 = new Client("Patricio", "Ortega", "1752994952", "123");
		Client client2 = new Client("Ivanova", "Ortega", "1752994949", "123");
		List<Client> list = Arrays.asList(client1, client2);
		list.forEach(clientRepository::save);
	}
}
