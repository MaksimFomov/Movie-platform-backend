package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.AuthenticationResponseDTO;
import com.fomov.movieplatform.dto.OrderRequestDTO;
import com.fomov.movieplatform.dto.UserRequestDTO;
import com.fomov.movieplatform.dto.UserResponseDTO;
import com.fomov.movieplatform.exception.exists.UsernameExistsException;
import com.fomov.movieplatform.exception.notfound.EventNotFoundException;
import com.fomov.movieplatform.exception.notfound.UserNotFoundException;
import com.fomov.movieplatform.exception.other.InvalidLoginCredentialsException;
import com.fomov.movieplatform.exception.other.NoTicketsException;
import com.fomov.movieplatform.facade.UserFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        try {
            userFacade.registerUser(userRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (UsernameExistsException e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDTO userRequestDTO) {
        try {
            AuthenticationResponseDTO response = userFacade.loginUser(userRequestDTO);
            return ResponseEntity.ok(response);
        } catch (InvalidLoginCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    ResponseEntity<?> getAllUsers() {
        try {
            List<UserResponseDTO> userResponseDTOS = userFacade.getAllUsers();
            return ResponseEntity.ok(userResponseDTOS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        try {
            UserResponseDTO userResponseDTO = userFacade.getUserById(userId);
            return ResponseEntity.ok(userResponseDTO);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updatePassword(@PathVariable Long userId, @RequestBody Map<String, String> newPasswordMap) {
        try {
            String newPassword = newPasswordMap.get("password");
            userFacade.updatePassword(userId, newPassword);
            return ResponseEntity.ok("Password updated successfully");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/{userId}/orders")
    ResponseEntity<String> addOrder(@PathVariable Long userId, @RequestBody OrderRequestDTO orderRequestDTO) {
        try {
            userFacade.addOrder(userId, orderRequestDTO);
            return ResponseEntity.ok("Order added successfully");
        } catch (UserNotFoundException | EventNotFoundException | NoTicketsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long userId, @PathVariable Long orderId) {
        try {
            userFacade.cancelOrder(userId, orderId);
            return ResponseEntity.ok("Order deleted successfully");
        } catch (UserNotFoundException | EventNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

