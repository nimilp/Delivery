package com.keralakitchen.delivery.controller;

import com.keralakitchen.delivery.entity.Users;
import com.keralakitchen.delivery.exception.CreateUserException;
import com.keralakitchen.delivery.exception.NoUserException;
import com.keralakitchen.delivery.exception.NoUsersException;
import com.keralakitchen.delivery.model.User;
import com.keralakitchen.delivery.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/users")
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
