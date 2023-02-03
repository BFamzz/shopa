package com.famzzie.cart.interfaces;

import com.famzzie.clients.cart.request.CreateCartRequest;
import com.famzzie.clients.cart.response.CreateCartResponse;

public interface CartService {
    CreateCartResponse createCart(CreateCartRequest createCartRequest);
}
