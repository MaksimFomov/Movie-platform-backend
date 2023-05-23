package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.AuthenticationResponseDTO;
import com.fomov.movieplatform.dto.OrderRequestDTO;
import com.fomov.movieplatform.dto.UserRequestDTO;
import com.fomov.movieplatform.dto.UserResponseDTO;
import com.fomov.movieplatform.facade.UserFacade;
import com.fomov.movieplatform.mapper.OrderRequestMapper;
import com.fomov.movieplatform.mapper.UserRequestMapper;
import com.fomov.movieplatform.mapper.UserResponseMapper;
import com.fomov.movieplatform.model.Order;
import com.fomov.movieplatform.model.User;
import com.fomov.movieplatform.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final OrderRequestMapper orderRequestMapper;

    public UserFacadeImpl(UserService userService, UserRequestMapper userRequestMapper, UserResponseMapper userResponseMapper, OrderRequestMapper orderRequestMapper) {
        this.userService = userService;
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
        this.orderRequestMapper = orderRequestMapper;
    }

    @Override
    public void registerUser(UserRequestDTO userRequestDTO) {
        User user = userRequestMapper.toUser(userRequestDTO);
        userService.registerUser(user);
    }

    @Override
    public AuthenticationResponseDTO loginUser(UserRequestDTO userRequestDTO) {
        User user = userRequestMapper.toUser(userRequestDTO);
        AuthenticationResponseDTO authenticationResponseDTO = new AuthenticationResponseDTO();
        authenticationResponseDTO.setToken(userService.loginUser(user));
        return authenticationResponseDTO;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> receivedUsers = userService.getAllUsers();
        return userResponseMapper.toUserResponseDTOs(receivedUsers);
    }

    @Override
    public UserResponseDTO getUserById(Long userId) {
        User receivedUser = userService.getUserById(userId);
        return userResponseMapper.toUserResponseDTO(receivedUser);
    }

    @Override
    public void updatePassword(Long userId, String newPassword) {
        userService.updatePassword(userId, newPassword);
    }

    @Override
    public void addOrder(Long userId, OrderRequestDTO orderRequestDTO) {
        Order order = orderRequestMapper.toOrder(orderRequestDTO);
        userService.addOrder(userId, order);
    }

    @Override
    public void cancelOrder(Long userId, Long orderId) {
        userService.cancelOrder(userId, orderId);
    }
}
