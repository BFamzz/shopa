package com.famzzie.inventory.interfaces;

import com.famzzie.inventory.api.request.CreateInventoryRequest;
import com.famzzie.inventory.api.response.CreateInventoryResponse;

public interface InventoryService {

    CreateInventoryResponse createInventory(CreateInventoryRequest createInventoryRequest);
}
