package com.famzzie.cart.service;

import com.famzzie.cart.entity.Cart;
import com.famzzie.cart.interfaces.CartService;
import com.famzzie.cart.repository.CartRepository;
import com.famzzie.clients.cart.request.CreateCartRequest;
import com.famzzie.clients.cart.response.CreateCartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public CreateCartResponse createCart(CreateCartRequest createCartRequest) {
        if (createCartRequest.customerId() < 1)
            throw new RuntimeException();

        Cart cart = Cart.builder()
                .customerId(createCartRequest.customerId())
                .build();
        cartRepository.save(cart);
        return new CreateCartResponse(true);
    }
}
