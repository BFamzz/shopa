package com.famzzie.inventory.exception.types;

public class InvalidPaginationParamException extends RuntimeException {
    public InvalidPaginationParamException(String message) {
        super(message);
    }
}
