package com.example.customer_api.api.error;

import java.util.Map;

public class ValidationErrorResponse {

    private final String error = "VALIDATION_ERROR";
    private final Map<String, String> fields;

    public ValidationErrorResponse(Map<String, String> fields) {
        this.fields = fields;
    }

    public String getError() {
        return error;
    }

    public Map<String, String> getFields() {
        return fields;
    }
}