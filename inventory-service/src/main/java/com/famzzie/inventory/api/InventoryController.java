package com.famzzie.inventory.api;

import com.famzzie.inventory.api.request.CreateInventoryRequest;
import com.famzzie.inventory.api.response.CreateInventoryResponse;
import com.famzzie.inventory.interfaces.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateInventoryResponse> createInventory(
            @RequestBody CreateInventoryRequest createInventoryRequest) {
        return  new ResponseEntity<>(inventoryService.createInventory(createInventoryRequest),
                HttpStatus.OK);
    }
}
