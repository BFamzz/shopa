package com.famzzie.customer.exception.types;

public class InvalidRequestBodyException extends RuntimeException{
    public InvalidRequestBodyException(String message) {
        super(message);
    }
}
