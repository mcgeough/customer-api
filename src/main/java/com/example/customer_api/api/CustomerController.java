package com.example.customer_api.api;

import com.example.customer_api.domain.Customer;
import com.example.customer_api.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer request) {
        return service.create(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail()
        );
    }

    // READ
    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        return service.get(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Customer update(
            @PathVariable Long id,
            @RequestBody Customer request) {
        return service.update(
                id,
                request.getFirstName(),
                request.getLastName()
        );
    }

    // DELETE (SOFT)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}