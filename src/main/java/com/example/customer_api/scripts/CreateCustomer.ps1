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