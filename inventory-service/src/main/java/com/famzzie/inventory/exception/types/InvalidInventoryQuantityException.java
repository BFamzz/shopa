package com.famzzie.inventory.exception.types;

public class InvalidInventoryQuantityException extends RuntimeException {

    public InvalidInventoryQuantityException(String message) {
        super(message);
    }
}
