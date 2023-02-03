package com.famzzie.customer.exception;

import com.famzzie.customer.exception.types.InvalidRequestBodyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = InvalidRequestBodyException.class)
    public ResponseEntity<ApiException> invalidRequestBodyException(InvalidRequestBodyException exception) {
        ApiException apiException = new ApiException(Boolean.FALSE, exception.getMessage(), exception,
                ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
