package com.example.customer_api.api.mapper;

import com.example.customer_api.api.dto.CustomerResponse;
import com.example.customer_api.domain.Customer;

public class CustomerMapper {

    public static CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(
            customer.getId(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEmail(),
            customer.getStatus(),
            customer.getCreatedAt()
        );
    }
}