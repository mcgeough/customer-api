package com.example.customer_api.api.error;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ApiError> handleBadRequest(
    IllegalArgumentException ex
  ) {
    ApiError error = new ApiError(
      HttpStatus.BAD_REQUEST.value(),
      ex.getMessage()
    );
    return ResponseEntity.badRequest().body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationErrorResponse> handleValidationErrors(
    MethodArgumentNotValidException ex
  ) {
    Map<String, String> errors = new HashMap<>();

    ex
      .getBindingResult()
      .getFieldErrors()
      .forEach(error -> errors.put(error.getField(), error.getDefaultMessage())
      );

    return ResponseEntity
      .badRequest()
      .body(new ValidationErrorResponse(errors));
  }
}
