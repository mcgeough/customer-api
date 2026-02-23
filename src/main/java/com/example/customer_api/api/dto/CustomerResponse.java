package com.example.customer_api.api.dto;

import com.example.customer_api.domain.CustomerStatus;
import java.time.Instant;

public class CustomerResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private CustomerStatus status;
    private Instant createdAt;

    public CustomerResponse(
            Long id,
            String firstName,
            String lastName,
            String email,
            CustomerStatus status,
            Instant createdAt) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}