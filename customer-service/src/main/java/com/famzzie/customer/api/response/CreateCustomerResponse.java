package com.famzzie.customer.api.response;

public record CreateCustomerResponse(
        boolean success,
        String message,
        Long accountId
) {
}
