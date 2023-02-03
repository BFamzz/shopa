package com.famzzie.customer.service;

import com.famzzie.customer.api.request.CreateCustomerRequest;
import com.famzzie.customer.api.response.CreateCustomerResponse;
import com.famzzie.customer.entity.Customer;
import com.famzzie.customer.interfaces.CustomerService;
import com.famzzie.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer newCustomer = Customer.builder()
                .firstName(createCustomerRequest.firstName())
                .lastName(createCustomerRequest.lastName())
                .email(createCustomerRequest.email())
                .phoneNumber(createCustomerRequest.phoneNumber())
                .createdAt(ZonedDateTime.now())
                .build();

        customerRepository.saveAndFlush(newCustomer);

        return new CreateCustomerResponse(Boolean.TRUE,
                "Account created successfully", newCustomer.getId());
    }
}
