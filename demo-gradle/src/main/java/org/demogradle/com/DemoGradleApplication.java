package org.demogradle.com;

import org.demogradle.com.domain.Customer;
import org.demogradle.com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoGradleApplication implements CommandLineRunner {

	
	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoGradleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		repository.deleteAll();
		
		// save a couple of customers
				repository.save(new Customer("Alice", "Smith"));
				repository.save(new Customer("Bob", "Smith"));

				// fetch all customers
				System.out.println("Customers found with findAll():");
				System.out.println("-------------------------------");
				for (Customer customer : repository.findAll()) {
					System.out.println(customer);
				}
				System.out.println();

				// fetch an individual customer
				System.out.println("Customer found with findByFirstName('Alice'):");
				System.out.println("--------------------------------");
				System.out.println(repository.findByFirstName("Alice"));

				System.out.println("Customers found with findByLastName('Smith'):");
				System.out.println("--------------------------------");
				for (Customer customer : repository.findByLastName("Smith")) {
					System.out.println(customer);
				}
		
	}
}
