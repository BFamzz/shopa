package com.famzzie.inventory.service;

import com.famzzie.inventory.api.request.CreateInventoryRequest;
import com.famzzie.inventory.api.response.CreateInventoryResponse;
import com.famzzie.inventory.entity.Inventory;
import com.famzzie.inventory.exception.types.InvalidInventoryQuantityException;
import com.famzzie.inventory.interfaces.InventoryService;
import com.famzzie.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public CreateInventoryResponse createInventory(CreateInventoryRequest createInventoryRequest) {

        if (createInventoryRequest.quantity() < 1)
            throw new InvalidInventoryQuantityException("Quantity should not be zero");

        Inventory inventory = Inventory.builder()
                .name(createInventoryRequest.name())
                .quantity(createInventoryRequest.quantity())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        inventoryRepository.saveAndFlush(inventory);
        return new CreateInventoryResponse(true, "Inventory created");
    }
}
