package com.famzzie.customer.api.response;

public record CreateCustomerResponse(
        Boolean success,
        String message,
        Long accountId
) {
}
