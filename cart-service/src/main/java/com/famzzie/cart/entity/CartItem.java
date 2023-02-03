package com.famzzie.cart.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class CartItem {

    private long inventoryId;

    private int quantity;
}
