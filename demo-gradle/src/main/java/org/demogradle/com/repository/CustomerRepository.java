package org.demogradle.com.repository;

import java.util.List;

import org.demogradle.com.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
}
