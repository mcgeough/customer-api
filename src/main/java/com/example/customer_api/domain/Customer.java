package com.example.customer_api.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(
    name = "customers",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerStatus status;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    // JPA requirement
    protected Customer() {}

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = CustomerStatus.ACTIVE;
        this.createdAt = Instant.now();
    }

    // ---- Domain behaviour ----

    public void updateName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void deactivate() {
        this.status = CustomerStatus.INACTIVE;
    }

    // ---- Getters ----

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public CustomerStatus getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }
}