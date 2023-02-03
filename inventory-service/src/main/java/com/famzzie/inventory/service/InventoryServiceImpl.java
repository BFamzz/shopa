package com.famzzie.inventory.service;

import com.famzzie.inventory.api.request.CreateInventoryRequest;
import com.famzzie.inventory.api.request.GetInventoryRequest;
import com.famzzie.inventory.api.response.CreateInventoryResponse;
import com.famzzie.inventory.api.response.GetInventoryResponse;
import com.famzzie.inventory.entity.Inventory;
import com.famzzie.inventory.exception.types.InvalidInventoryQuantityException;
import com.famzzie.inventory.exception.types.InvalidPaginationParamException;
import com.famzzie.inventory.interfaces.InventoryService;
import com.famzzie.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public GetInventoryResponse getInventory(GetInventoryRequest getInventoryRequest) {
        if (getInventoryRequest.pageNum() < 0 ||
                getInventoryRequest.pageSize() < 5 ||
                getInventoryRequest.pageSize() > 20
        )
            throw new InvalidPaginationParamException("Page num must be greater " +
                    "than or equals to '0' and page size is between 5 and 20 inclusive");

        PageRequest pageRequest = PageRequest.of(getInventoryRequest.pageNum(),
                getInventoryRequest.pageSize());

        Page<Inventory> inventoryPageList = inventoryRepository.findAll(pageRequest);
        return new GetInventoryResponse(true, "Inventory gotten",
                inventoryPageList.getContent());
    }
}
