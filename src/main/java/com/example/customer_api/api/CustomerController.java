package com.example.customer_api.api;

import com.example.customer_api.api.dto.CreateCustomerRequest;
import com.example.customer_api.api.dto.CustomerResponse;
import com.example.customer_api.api.mapper.CustomerMapper;
import com.example.customer_api.service.CustomerService;
import jakarta.validation.Valid;
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
  public CustomerResponse createCustomer(
    @Valid @RequestBody CreateCustomerRequest request
  ) {
    return CustomerMapper.toResponse(
      service.create(
        request.getFirstName(),
        request.getLastName(),
        request.getEmail()
      )
    );
  }

  // READ
  @GetMapping("/{id}")
  public CustomerResponse getCustomer(@PathVariable Long id) {
    return CustomerMapper.toResponse(service.get(id));
  }

  // UPDATE
  @PutMapping("/{id}")
  public CustomerResponse updateCustomer(
    @PathVariable Long id,
    @Valid @RequestBody CreateCustomerRequest request
  ) {
    return CustomerMapper.toResponse(
      service.update(id, request.getFirstName(), request.getLastName())
    );
  }

  // DELETE (SOFT)
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCustomer(@PathVariable Long id) {
    service.delete(id);
  }
}
