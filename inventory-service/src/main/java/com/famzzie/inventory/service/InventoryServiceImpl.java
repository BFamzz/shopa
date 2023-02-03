package com.famzzie.inventory.service;

import com.famzzie.inventory.api.request.CreateInventoryRequest;
import com.famzzie.inventory.api.request.GetInventoryRequest;
import com.famzzie.inventory.api.response.CreateInventoryResponse;
import com.famzzie.inventory.api.response.GetInventoryByIdResponse;
import com.famzzie.inventory.api.response.GetInventoryResponse;
import com.famzzie.inventory.entity.Inventory;
import com.famzzie.inventory.exception.types.InvalidInventoryException;
import com.famzzie.inventory.exception.types.InvalidPaginationParamException;
import com.famzzie.inventory.exception.types.InventoryNotFoundException;
import com.famzzie.inventory.interfaces.InventoryService;
import com.famzzie.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public CreateInventoryResponse createInventory(CreateInventoryRequest createInventoryRequest) {

        if (createInventoryRequest.quantity() < 1 ||
            createInventoryRequest.amount().compareTo(new BigDecimal("1.00")) < 0)
            throw new InvalidInventoryException("Quantity and amount should be greater than zero");

        Inventory inventory = Inventory.builder()
                .name(createInventoryRequest.name())
                .amount(createInventoryRequest.amount())
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

    @Override
    public GetInventoryByIdResponse getInventoryById(long inventoryId) {
        if (inventoryId < 1)
            throw new InventoryNotFoundException("Inventory not found. Please try again!");

        Optional<Inventory> inventory = inventoryRepository.findById(inventoryId);
        if (inventory.isEmpty())
            throw new InventoryNotFoundException("Inventory not found. Please try again!");

        return new GetInventoryByIdResponse(true, "Inventory retrieved",
                inventory.get());
    }
}
