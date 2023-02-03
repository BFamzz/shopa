package com.famzzie.inventory.interfaces;

import com.famzzie.inventory.api.request.CreateInventoryRequest;
import com.famzzie.inventory.api.request.GetInventoryRequest;
import com.famzzie.inventory.api.response.CreateInventoryResponse;
import com.famzzie.inventory.api.response.GetInventoryByIdResponse;
import com.famzzie.inventory.api.response.GetInventoryResponse;

public interface InventoryService {

    CreateInventoryResponse createInventory(CreateInventoryRequest createInventoryRequest);

    GetInventoryResponse getInventory(GetInventoryRequest getInventoryRequest);

    GetInventoryByIdResponse getInventoryById(long inventoryId);
}
