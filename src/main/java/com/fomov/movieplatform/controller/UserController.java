package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.AuthenticationRequestDTO;
import com.fomov.movieplatform.dto.AuthenticationResponseDTO;
import com.fomov.movieplatform.dto.UserRegistrationDTO;
import com.fomov.movieplatform.facade.UserFacade;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
}

