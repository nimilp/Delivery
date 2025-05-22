package com.keralakitchen.delivery.controller;

import com.keralakitchen.delivery.exception.NoUsersException;
import com.keralakitchen.delivery.model.Item;
import com.keralakitchen.delivery.model.User;
import com.keralakitchen.delivery.service.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/items")
@Tag(name="Items Api")
public class ItemController extends BaseController{

    @Autowired
    IUserService userService;

    @Operation(summary = "Get Items or categories", description = "Api Items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Operation is successful."),
            @ApiResponse(responseCode = "404", description = "")
    })

    @GetMapping
    public ResponseEntity<List<Item>> get() throws NoUsersException {
        log.info("in Items");
        Item item1 = new Item("1","Vegiterian","Vegiterian");
        Item item2 = new Item("2","Non-Vegiterian","Non Vegiterian");
        List<Item> items = List.of(item1, item2);
        if(!items.isEmpty()) {
            return new ResponseEntity<>(items, HttpStatus.OK);
        } else {
            throw new NoUsersException("{\"Message\":\"No Users\"}");
        }
    }
}
