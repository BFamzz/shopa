package com.famzzie.customer.api.server;

import com.famzzie.customer.api.request.CreateCustomerRequest;
import com.famzzie.customer.api.response.CreateCustomerResponse;
import com.famzzie.customer.api.response.GetCustomerResponse;
import com.famzzie.customer.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateCustomerResponse> createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return new ResponseEntity<>(customerService.createCustomer(createCustomerRequest),
                HttpStatus.CREATED);
    }

    @GetMapping(path = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetCustomerResponse> getCustomerById(@PathVariable(name = "customerId")long id) {
        return new ResponseEntity<>(customerService.getCustomerById(id),
                HttpStatus.OK);
    }
}
