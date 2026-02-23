$BaseUrl = "http://localhost:8080/api/v1/customers"

$update = @{
    firstName = "Niall"
    lastName  = "McG"
} | ConvertTo-Json

Invoke-RestMethod `
    -Method Put `
    -Uri "$BaseUrl/1" `
    -Body $update `
    -ContentType "application/json"