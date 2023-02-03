package com.famzzie.customer.api.request;

public record CreateCustomerRequest(
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {

}
