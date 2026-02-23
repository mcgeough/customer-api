package com.example.customer_api.service;

import com.example.customer_api.domain.Customer;
import com.example.customer_api.domain.CustomerStatus;
import com.example.customer_api.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // CREATE
    @Transactional
    public Customer create(String firstName, String lastName, String email) {
        if (repository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }
        return repository.save(new Customer(firstName, lastName, email));
    }

    // READ (ACTIVE ONLY)
    @Transactional(readOnly = true)
    public Customer get(Long id) {
        return repository.findByIdAndStatus(id, CustomerStatus.ACTIVE)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // UPDATE
    @Transactional
    public Customer update(Long id, String firstName, String lastName) {
        Customer customer = get(id);
        customer.updateName(firstName, lastName);
        return customer;
    }

    // DELETE (SOFT)
    @Transactional
    public void delete(Long id) {
        Customer customer = get(id);
        customer.deactivate();
    }
}