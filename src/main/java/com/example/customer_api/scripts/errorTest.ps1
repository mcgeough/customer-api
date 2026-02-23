Invoke-RestMethod `
  -Method Post `
  -Uri http://localhost:8080/api/v1/customers `
  -Body '{"firstName":"","lastName":"","email":"bad"}' `
  -ContentType "application/json"