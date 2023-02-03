package com.famzzie.customer.interfaces;

import com.famzzie.customer.api.request.CreateCustomerRequest;
import com.famzzie.customer.api.response.CreateCustomerResponse;
import com.famzzie.customer.api.response.GetCustomerResponse;

public interface CustomerService {
    CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);

    GetCustomerResponse getCustomerById(long id);
}
