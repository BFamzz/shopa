package com.famzzie.inventory.api.response;

import com.famzzie.inventory.entity.Inventory;

import java.util.List;

public record GetInventoryResponse(
        boolean success,
        String message,
        List<Inventory> data
) {
}
