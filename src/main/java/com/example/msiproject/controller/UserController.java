package com.example.msiproject.controller;

import com.example.msiproject.dto.UserDTO;
import com.example.msiproject.dto.UserValidationDTO;
import com.example.msiproject.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get User by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getUserById/{user_id}")
    @CrossOrigin(origins = "http://localhost:63342")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("user_id") Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }


    @ApiOperation(value = "POST Users validation by login,password and role", response = ResponseEntity.class)
    @PostMapping(value = "/validateUser")
    @CrossOrigin(origins = "http://localhost:63342")
    public ResponseEntity<UserDTO> validateUser(@RequestBody UserValidationDTO validUser) {
        logger.info("Checking if there is a user.....");
        return ResponseEntity.ok(userService.validateUser(validUser));
    }


    @ApiOperation(value = "Create Users (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createUser")
    @CrossOrigin(origins = "http://localhost:63342")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUserDTO = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDTO);
    }


    @ApiOperation(value = "Update Users (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateUsers/{id}")
    @CrossOrigin(origins = "http://localhost:63342")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO updatedUserDTO) {
        UserDTO updatedUser = userService.updateUser(id, updatedUserDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @ApiOperation(value = "Delete Users (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteUsers/{id}")
    @CrossOrigin(origins = "http://localhost:63342")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    @ApiOperation(value = "Get all Users (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllUsers")
    @CrossOrigin(origins = "http://localhost:63342")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        logger.info("Getting all Users");
        List<UserDTO> users = userService.getAllUsers();
        logger.info("Got {} users", users.size());
        return ResponseEntity.ok(users);
    }

}
