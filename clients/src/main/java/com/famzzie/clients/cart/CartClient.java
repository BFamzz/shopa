package com.famzzie.clients.cart;

import com.famzzie.clients.cart.request.CreateCartRequest;
import com.famzzie.clients.cart.response.CreateCartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cart-service", path = "/api/v1/cart")
public interface CartClient {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateCartResponse createCart(@RequestBody CreateCartRequest createCartRequest);
}
