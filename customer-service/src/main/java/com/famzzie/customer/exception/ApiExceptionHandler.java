package com.famzzie.customer.exception;

import com.famzzie.customer.exception.types.CustomerNotFoundException;
import com.famzzie.customer.exception.types.InvalidRequestBodyException;
import com.famzzie.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = InvalidRequestBodyException.class)
    public ResponseEntity<ApiException> invalidRequestBodyException(InvalidRequestBodyException exception) {
        ApiException apiException = new ApiException(false, exception.getMessage());
        log.error(exception.getCause().toString());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<ApiException> invalidRequestBodyException(CustomerNotFoundException exception) {
        ApiException apiException = new ApiException(false, exception.getMessage());
        log.error(exception.getCause().toString());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
