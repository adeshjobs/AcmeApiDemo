package com.acme.apidemo;

import com.acme.apidemo.entity.Customer;
import com.acme.apidemo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApidemoApplication {
	private static final Logger log = LoggerFactory.getLogger(ApidemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApidemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
			repository.save(new Customer("Chloe", "O'Brian", "Chloe@acme.com"));
			repository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
			repository.save(new Customer("David", "Palmer", "Davif@acme.com"));
			repository.save(new Customer("Michelle", "Dessler", "Michelle@acme.com"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}
