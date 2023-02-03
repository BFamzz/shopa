package com.famzzie.inventory.api.request;

public record CreateInventoryRequest(
        String name,
        long quantity
) {
}
