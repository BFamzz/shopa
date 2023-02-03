package com.famzzie.exception;

public record ApiException(
        boolean success,

        String message
) {
}
