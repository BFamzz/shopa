package com.famzzie.cart.api.server;

import com.famzzie.cart.interfaces.CartService;
import com.famzzie.clients.cart.request.CreateCartRequest;
import com.famzzie.clients.cart.response.CreateCartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateCartResponse> createCart(@RequestBody CreateCartRequest createCartRequest) {
        return new ResponseEntity<>(cartService.createCart(createCartRequest), HttpStatus.CREATED);
    }
}
