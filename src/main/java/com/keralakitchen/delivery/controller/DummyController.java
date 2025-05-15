package com.keralakitchen.delivery.controller;

import com.keralakitchen.delivery.exception.NoUsersException;
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
@RequestMapping("/dummy")
@Tag(name="Dummy Api")
public class DummyController extends BaseController{

    @Autowired
    IUserService userService;

    @Operation(summary = "Get Dummy", description = "Api Dummy")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Operation is successful."),
            @ApiResponse(responseCode = "404", description = "")
    })
    @GetMapping
    public ResponseEntity<List<User>> get() throws NoUsersException {
        log.info("in Dummy");
        User user = new User("John","","","");
        List<User> users = userService.getUsers(user);
        if(!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            throw new NoUsersException("{\"Message\":\"No Users\"}");
        }
    }
}
