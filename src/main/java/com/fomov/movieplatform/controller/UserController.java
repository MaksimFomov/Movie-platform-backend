package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.AuthenticationRequest;
import com.fomov.movieplatform.dto.AuthenticationResponse;
import com.fomov.movieplatform.dto.UserRegistrationDTO;
import com.fomov.movieplatform.security.JwtTokenUtil;
import com.fomov.movieplatform.service.impl.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("Hello");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO registrationDto) {
        try {
            userService.registerUser(registrationDto.getUsername(), registrationDto.getPassword(), registrationDto.getRole());
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal());

        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(token);

        return ResponseEntity.ok(response);
    }
}

