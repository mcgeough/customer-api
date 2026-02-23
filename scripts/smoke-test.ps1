$BaseUrl = "http://localhost:8080/api/v1/customers"

Write-Host "Running API smoke test..."

# Create customer
$body = @{
    firstName = "CI"
    lastName  = "SmokeTest"
    email     = "ci-smoketest@example.com"
} | ConvertTo-Json

$response = Invoke-RestMethod `
    -Method Post `
    -Uri $BaseUrl `
    -Body $body `
    -ContentType "application/json"

if (-not $response.id) {
    throw "Smoke test failed: No customer ID returned"
}

$customerId = $response.id
Write-Host "Customer created with ID $customerId"

# Fetch customer
$getResponse = Invoke-RestMethod `
    -Method Get `
    -Uri "$BaseUrl/$customerId"

if ($getResponse.email -ne "ci-smoketest@example.com") {
    throw "Smoke test failed: Customer data mismatch"
}

Write-Host "Smoke test passed" 