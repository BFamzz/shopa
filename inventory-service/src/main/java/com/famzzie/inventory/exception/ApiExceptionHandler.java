package com.famzzie.inventory.exception;

import com.famzzie.exception.ApiException;
import com.famzzie.inventory.exception.types.InvalidInventoryException;
import com.famzzie.inventory.exception.types.InvalidPaginationParamException;
import com.famzzie.inventory.exception.types.InventoryNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = InvalidInventoryException.class)
    public ResponseEntity<ApiException> invalidInventoryQuantityException(
            InvalidInventoryException exception) {
        ApiException apiException = new ApiException(false, exception.getMessage());
        log.error(exception.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidPaginationParamException.class)
    public ResponseEntity<ApiException> invalidPaginationParamException(
            InvalidPaginationParamException exception) {
        ApiException apiException = new ApiException(false, exception.getMessage());
        log.error(exception.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InventoryNotFoundException.class)
    public ResponseEntity<ApiException> inventoryNotFoundException(
            InventoryNotFoundException exception) {
        ApiException apiException = new ApiException(false, exception.getMessage());
        log.error(exception.getMessage());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
