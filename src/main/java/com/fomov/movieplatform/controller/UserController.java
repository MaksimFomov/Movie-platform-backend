package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.AuthenticationRequest;
import com.fomov.movieplatform.dto.AuthenticationResponse;
import com.fomov.movieplatform.dto.UserRegistrationDTO;
import com.fomov.movieplatform.facade.UserFacade;
import com.fomov.movieplatform.security.JwtTokenUtil;
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
    private final UserFacade userFacade;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public UserController(UserFacade userFacade, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.userFacade = userFacade;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
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
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
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

