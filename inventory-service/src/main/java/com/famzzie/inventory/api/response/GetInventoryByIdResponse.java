package com.famzzie.inventory.api.response;

import com.famzzie.inventory.entity.Inventory;

public record GetInventoryByIdResponse(
        boolean success,
        String message,
        Inventory data
) {
}
