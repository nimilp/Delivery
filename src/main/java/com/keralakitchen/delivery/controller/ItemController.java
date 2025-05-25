package com.keralakitchen.delivery.controller;

import com.keralakitchen.delivery.model.Items;
import com.keralakitchen.delivery.exception.CreateItemException;
import com.keralakitchen.delivery.exception.NoDataException;
import com.keralakitchen.delivery.model.User;
import com.keralakitchen.delivery.service.service.IItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/items")
@Tag(name="Items Api")
public class ItemController extends BaseController{

    @Autowired
    IItemService itemService;

    @Operation(summary = "Get Items or categories", description = "Api Items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Operation is successful."),
            @ApiResponse(responseCode = "404", description = "")
    })

    @GetMapping("")
    public ResponseEntity<List<Items>> getCategories() throws NoDataException {
        log.info("in Categories");
        List<Items> items = itemService.getItems("");
        if(!items.isEmpty()) {
            return new ResponseEntity<>(items, HttpStatus.OK);
        } else {
            throw new NoDataException("{\"Message\":\"No Items\"}");
        }
    }
    @GetMapping("/parent/{id}")
    public ResponseEntity<Items> getCategory(@PathVariable String id) throws NoDataException {
        log.info("in Category");
        Items items = itemService.getCategory(id);
        return new ResponseEntity<>(items, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Items>> get(@PathVariable String id) throws NoDataException {
        log.info("in Items");
        List<Items> items = itemService.getItems(id);
        if(!items.isEmpty()) {
            return new ResponseEntity<>(items, HttpStatus.OK);
        } else {
            throw new NoDataException("{\"Message\":\"No Items\"}");
        }
    }

    @PostMapping
    @Operation(summary = "Create an Item / Category", description = "Api to create Item / Category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item / Category is created"),
            @ApiResponse(responseCode = "500", description = "Unsuccessful Operation.")
    })

    public ResponseEntity<Items> createItem(@RequestBody Items item) throws CreateItemException {

        try {
            Optional<Items> newItem = itemService.create(item);
            if(newItem.isPresent() && ObjectUtils.isNotEmpty(newItem.get().getId())) {
                return new ResponseEntity<>(newItem.get(), HttpStatus.CREATED);
            } else {
                throw new CreateItemException(String.format("Error while creating Item / Category: %s", item.toString()));
            }
        } catch (Exception e) {
            throw new CreateItemException(String.format("Error while creating Item / Category: %s", item.toString()));
        }
    }
}
