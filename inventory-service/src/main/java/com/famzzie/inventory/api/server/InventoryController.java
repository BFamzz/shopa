package com.famzzie.inventory.api.server;

import com.famzzie.inventory.api.request.CreateInventoryRequest;
import com.famzzie.inventory.api.request.GetInventoryRequest;
import com.famzzie.inventory.api.response.CreateInventoryResponse;
import com.famzzie.inventory.api.response.GetInventoryByIdResponse;
import com.famzzie.inventory.api.response.GetInventoryResponse;
import com.famzzie.inventory.interfaces.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateInventoryResponse> createInventory(
            @RequestBody CreateInventoryRequest createInventoryRequest) {
        return new ResponseEntity<>(inventoryService.createInventory(createInventoryRequest),
                HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetInventoryResponse> getInventory(
            @RequestParam int pageNum, @RequestParam int pageSize) {
        GetInventoryRequest getInventoryRequest = new GetInventoryRequest(pageNum, pageSize);
        return new ResponseEntity<>(inventoryService.getInventory(getInventoryRequest), HttpStatus.OK);
    }

    @GetMapping(path = "/{inventoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetInventoryByIdResponse> getInventoryById(
            @PathVariable(name = "inventoryId") long inventoryId
    ) {
        return new ResponseEntity<>(inventoryService.getInventoryById(inventoryId),
                HttpStatus.OK);
    }
}
