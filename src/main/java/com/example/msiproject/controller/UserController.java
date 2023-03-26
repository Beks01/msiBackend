package com.example.msiproject.controller;

import com.example.msiproject.dto.UserDTO;
import com.example.msiproject.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get User by ID (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getUserById/{user_id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("user_id") Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @ApiOperation(value = "Create Users (WEB)", response = ResponseEntity.class)
    @PostMapping(value = "/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUserDTO = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDTO);
    }


    @ApiOperation(value = "Update Users (WEB)", response = ResponseEntity.class)
    @PutMapping(value = "/updateUsers/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO updatedUserDTO) {
        UserDTO updatedUser = userService.updateUser(id, updatedUserDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @ApiOperation(value = "Delete Users (WEB)", response = ResponseEntity.class)
    @DeleteMapping(value = "/deleteUsers/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Get all Users (WEB)", response = ResponseEntity.class)
    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
