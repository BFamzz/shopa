package com.famzzie.customer.service;

import com.famzzie.customer.api.request.CreateCustomerRequest;
import com.famzzie.customer.api.response.CreateCustomerResponse;
import com.famzzie.customer.api.response.GetCustomerResponse;
import com.famzzie.customer.entity.Customer;
import com.famzzie.customer.exception.types.CustomerNotFoundException;
import com.famzzie.customer.exception.types.InvalidRequestBodyException;
import com.famzzie.customer.interfaces.CustomerService;
import com.famzzie.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private boolean validateCreateCustomerRequestBody(CreateCustomerRequest createCustomerRequest) {
        int NAME_LENGTH = 50;
        int EMAIL_LENGTH = 50;
        int PHONE_NUMBER_LENGTH = 15;
        return createCustomerRequest.firstName().length() <= NAME_LENGTH &&
                createCustomerRequest.lastName().length() <= NAME_LENGTH &&
                createCustomerRequest.email().length() <= EMAIL_LENGTH &&
                createCustomerRequest.phoneNumber().length() <= PHONE_NUMBER_LENGTH;
    }

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
        if (!validateCreateCustomerRequestBody(createCustomerRequest))
            throw new InvalidRequestBodyException("Names and email should not exceed 50 characters " +
                    "and phone number should not exceed 15 characters. Please try again!");

        Customer newCustomer = Customer.builder()
                .firstName(createCustomerRequest.firstName())
                .lastName(createCustomerRequest.lastName())
                .email(createCustomerRequest.email())
                .phoneNumber(createCustomerRequest.phoneNumber())
                .createdAt(ZonedDateTime.now())
                .build();
        try {
            customerRepository.saveAndFlush(newCustomer);
        } catch (DataAccessException exception) {
            throw new InvalidRequestBodyException("Email and phone number must be unique. " +
                    "Please try again");
        }

        return new CreateCustomerResponse(Boolean.TRUE,
                "Account created successfully", newCustomer.getId());
    }

    @Override
    public GetCustomerResponse getCustomerById(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty())
            throw new CustomerNotFoundException("Not found. Please try again!");
        return new GetCustomerResponse(Boolean.TRUE, "Customer retrieved successfully",
                customer.get());
    }
}
