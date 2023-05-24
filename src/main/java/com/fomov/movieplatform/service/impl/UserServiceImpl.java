package com.fomov.movieplatform.service.impl;

import com.fomov.movieplatform.exception.exists.UsernameExistsException;
import com.fomov.movieplatform.exception.notfound.EventNotFoundException;
import com.fomov.movieplatform.exception.notfound.UserNotFoundException;
import com.fomov.movieplatform.exception.other.InvalidLoginCredentialsException;
import com.fomov.movieplatform.exception.other.NoTicketsException;
import com.fomov.movieplatform.model.Event;
import com.fomov.movieplatform.model.Order;
import com.fomov.movieplatform.model.User;
import com.fomov.movieplatform.repository.EventRepository;
import com.fomov.movieplatform.repository.UserRepository;
import com.fomov.movieplatform.security.JwtTokenUtil;
import com.fomov.movieplatform.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, EventRepository eventRepository, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UsernameExistsException("Username already exists: " + user.getUsername());
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole("user");
        userRepository.save(newUser);
    }

    @Override
    public String loginUser(User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return jwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal());
        } catch (BadCredentialsException e) {
            throw new InvalidLoginCredentialsException("Invalid login credentials");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
    }

    @Override
    public void updatePassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

        System.out.println(newPassword);
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public void addOrder(Long userId, Order order) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

        user.getOrders().add(order);
        userRepository.save(user);

        Event event = eventRepository.findById(order.getEvent().getId())
                .orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + order.getEvent().getId()));
        if(event.getNumberOfTickets() == 0) {
            throw new NoTicketsException("No tickets");
        }
        event.setNumberOfTickets(event.getNumberOfTickets() - 1);
    }

    @Override
    public void cancelOrder(Long userId, Long orderId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

        Order orderToCancel = null;
        for (Order order : user.getOrders()) {
            if (order.getId().equals(orderId)) {
                orderToCancel = order;
                break;
            }
        }

        if (orderToCancel != null) {
            user.getOrders().remove(orderToCancel);
            userRepository.save(user);

            Event event = eventRepository.findById(orderId)
                    .orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + orderId));
            event.setNumberOfTickets(event.getNumberOfTickets() + 1);
        }
    }
}



