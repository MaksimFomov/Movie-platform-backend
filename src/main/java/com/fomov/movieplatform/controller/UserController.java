package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.*;
import com.fomov.movieplatform.exception.notfound.EventNotFoundException;
import com.fomov.movieplatform.exception.notfound.UserNotFoundException;
import com.fomov.movieplatform.exception.other.NoTicketsException;
import com.fomov.movieplatform.facade.UserFacade;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        try {
            userFacade.registerUser(userRegistrationDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody AuthenticationRequestDTO authenticationRequestDTO) {
        String token = userFacade.loginUser(authenticationRequestDTO);

        AuthenticationResponseDTO response = new AuthenticationResponseDTO();
        response.setToken(token);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userFacade.getAllUsers();
        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        try {
            UserDTO userDTO = userFacade.getUserById(userId);
            return ResponseEntity.ok(userDTO);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updatePassword(@PathVariable Long userId, @RequestBody Map<String, String> newPasswordMap) {
        String newPassword = newPasswordMap.get("password");
        userFacade.updatePassword(userId, newPassword);
        return ResponseEntity.ok("Password updated successfully");
    }

    @PostMapping("/{userId}/orders")
    ResponseEntity<String> addOrder(@PathVariable Long userId, @RequestBody OrderDTO orderDTO) {
        try {
            userFacade.addOrder(userId, orderDTO);
            return ResponseEntity.ok("Order added successfully");
        } catch (UserNotFoundException | EventNotFoundException | NoTicketsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long userId, @PathVariable Long orderId) {
        try {
            userFacade.cancelOrder(userId, orderId);
            return ResponseEntity.ok("Order deleted successfully");
        } catch (UserNotFoundException | EventNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

