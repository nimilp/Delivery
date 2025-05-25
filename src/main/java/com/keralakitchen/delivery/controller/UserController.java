//package com.keralakitchen.delivery.controller;
//
//import com.keralakitchen.delivery.entity.Users;
//import com.keralakitchen.delivery.exception.CreateUserException;
//import com.keralakitchen.delivery.exception.NoUserException;
//import com.keralakitchen.delivery.model.User;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController()
//@RequestMapping("/users")
//@Tag(name="User Api")
//public class UserController extends BaseController{
//
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);
//    @Autowired
//    IUserService userService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<String> getUser(@PathVariable String id) throws NoUserException {
//
//        throw new NoUserException("{\"Message\":\"No user Found\",\"id\":"+id+"}");
//    }
//
////    @PostMapping("/search")
////    @Operation(summary = "Get users By First Name or Last Name", description = "Api to Fetch users by First Name or Last Name")
////    @ApiResponses(value = {
////            @ApiResponse(responseCode = "400", description = "Operation is successful."),
////            @ApiResponse(responseCode = "404", description = "")
////    })
////    public ResponseEntity<List<User>> getUsers(@RequestBody User user) throws NoUsersException {
////
////        List<User> users = userService.getUsers(user);
////        if(!users.isEmpty()) {
////            return new ResponseEntity<>(users,HttpStatus.OK);
////        } else {
////            throw new NoUsersException("{\"Message\":\"No Users\"}");
////        }
////    }
////
////    @PostMapping
////    @Operation(summary = "Create a User", description = "Api to create User")
////    @ApiResponses(value = {
////            @ApiResponse(responseCode = "201", description = "User is created"),
////            @ApiResponse(responseCode = "500", description = "Unsuccessful Operation.")
////    })
////
////    public ResponseEntity<User> createUser(@RequestBody User user) throws CreateUserException {
////
////        try {
////            Optional<Users> newUser = userService.createUser(user);
////            return new ResponseEntity<>(HttpStatus.CREATED);
////        } catch (Exception e){
////            throw new CreateUserException(String.format("Error while creating user: %s", user.toString()));
////        }
////    }
//}
