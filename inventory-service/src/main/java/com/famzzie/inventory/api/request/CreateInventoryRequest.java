package com.famzzie.inventory.api.request;

import java.math.BigDecimal;

public record CreateInventoryRequest(
        String name,
        BigDecimal amount,
        long quantity
) {
}
