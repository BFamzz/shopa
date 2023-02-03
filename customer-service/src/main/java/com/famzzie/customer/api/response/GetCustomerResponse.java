package com.famzzie.customer.api.response;

import com.famzzie.customer.entity.Customer;

public record GetCustomerResponse(
        Boolean success,
        String message,
        Customer data
) {
}
