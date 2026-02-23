# Customer API

A production-style REST API built with Spring Boot that manages customer data with full CRUD functionality, soft deletes, and automated CI validation.

This project demonstrates clean backend architecture, domain-driven design principles, and end-to-end CI testing using GitHub Actions and PowerShell.



## Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 (in-memory database)
- Maven
- GitHub Actions (CI)
- PowerShell (API client & smoke tests)


## Architecture

The application follows a layered architecture:

- **Domain** – Core business entities and rules (`Customer`, `CustomerStatus`)
- **Repository** – Persistence layer using Spring Data JPA
- **Service** – Business logic and transaction management
- **API (Controller)** – HTTP layer exposing REST endpoints

Each layer has a single responsibility and depends only on layers beneath it.


## Domain Model

### Customer
- `id` – Primary key
- `firstName`
- `lastName`
- `email` (unique)
- `status` (`ACTIVE`, `INACTIVE`)
- `createdAt`

Customers are **soft-deleted** by setting their status to `INACTIVE`.
Inactive customers are not retrievable through the API.


## API Endpoints

Base path: `/api/v1/customers`

| Method | Endpoint | Description |
|------|--------|------------|
| POST | `/` | Create a new customer |
| GET | `/{id}` | Retrieve an active customer |
| PUT | `/{id}` | Update customer name |
| DELETE | `/{id}` | Soft delete customer |


## Running the Application

### Prerequisites
- Java 17+
- Maven

### Start the app
```bash
mvn spring-boot:run

http://localhost:8080
jdbc:h2:mem:testdb



Example: Create a customer

```powershell
$BaseUrl = "http://localhost:8080/api/v1/customers"

$body = @{
    firstName = "Niall"
    lastName  = "McGeough"
    email     = "niall@example.com"
} | ConvertTo-Json

Invoke-RestMethod `
  -Method Post `
  -Uri $BaseUrl `
  -Body $body `
  -ContentType "application/json"



  CI / CD (to follow - Niall)
## Continuous Integration

This project uses **GitHub Actions** for CI.

On every push or pull request:
1. The project is built with Maven
2. The Spring Boot application is started
3. A PowerShell-based smoke test runs against the live API
4. The pipeline fails if any step fails

This ensures the API is always deployable and functional.


## Purpose

This project was built to demonstrate:
- Clean backend architecture
- Practical Spring Boot usage
- Realistic API design
- CI/CD integration
- Automation-friendly API testing

It is intentionally minimal but production-oriented