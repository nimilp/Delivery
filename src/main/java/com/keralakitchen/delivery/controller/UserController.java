package com.keralakitchen.delivery.controller;

import com.keralakitchen.delivery.entity.Users;
import com.keralakitchen.delivery.exception.CreateUserException;
import com.keralakitchen.delivery.exception.NoUserException;
import com.keralakitchen.delivery.exception.NoUsersException;
import com.keralakitchen.delivery.model.User;
import com.keralakitchen.delivery.service.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/users")
@Tag(name="User Api")
public class UserController extends BaseController{

    @Autowired
    IUserService userService;
    @GetMapping("")
    public ResponseEntity<String> getUsers() throws NoUsersException {
        throw new NoUsersException("{\"Message\":\"No Users\"}");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable String id) throws NoUserException {

        throw new NoUserException("{\"Message\":\"No user Found\",\"id\":"+id+"}");
    }

    @GetMapping("/find")
    @Operation(summary = "Get a User By FirstName", description = "Api to Fetch users by First Name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Operation is successfully"),
            @ApiResponse(responseCode = "404", description = "")
    })
    public ResponseEntity<User> getUserByFirstName(@RequestParam String firstName){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) throws CreateUserException {

        try {
            Optional<Users> newUser = userService.createUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){

            throw new CreateUserException(String.format("Error while creating user: %s", user.toString()));
        }
    }
}
