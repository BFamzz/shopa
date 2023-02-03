package com.famzzie.inventory.api.request;

public record GetInventoryRequest(
        int pageNum,
        int pageSize
) {
}
