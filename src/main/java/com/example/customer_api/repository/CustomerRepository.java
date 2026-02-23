package com.example.customer_api.repository;

import com.example.customer_api.domain.Customer;
import com.example.customer_api.domain.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByIdAndStatus(Long id, CustomerStatus status);

    boolean existsByEmail(String email);
}