$BaseUrl = "http://localhost:8080/api/v1/customers"

try {
    Invoke-RestMethod -Method Delete -Uri "$BaseUrl/1"
} catch {
    $_.ErrorDetails.Message
}