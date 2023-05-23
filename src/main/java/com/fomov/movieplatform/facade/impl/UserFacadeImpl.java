package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.AuthenticationRequestDTO;
import com.fomov.movieplatform.dto.OrderDTO;
import com.fomov.movieplatform.dto.UserDTO;
import com.fomov.movieplatform.dto.UserRegistrationDTO;
import com.fomov.movieplatform.facade.UserFacade;
import com.fomov.movieplatform.mapper.AuthenticationRequestMapper;
import com.fomov.movieplatform.mapper.OrderMapper;
import com.fomov.movieplatform.mapper.UserMapper;
import com.fomov.movieplatform.mapper.UserRegistrationMapper;
import com.fomov.movieplatform.model.Order;
import com.fomov.movieplatform.model.User;
import com.fomov.movieplatform.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final UserRegistrationMapper userRegistrationMapper;
    private final AuthenticationRequestMapper authenticationRequestMapper;
    private final UserMapper userMapper;
    private final OrderMapper orderMapper;

    public UserFacadeImpl(UserService userService, UserRegistrationMapper userRegistrationMapper, AuthenticationRequestMapper authenticationRequestMapper, UserMapper userMapper, OrderMapper orderMapper) {
        this.userService = userService;
        this.userRegistrationMapper = userRegistrationMapper;
        this.authenticationRequestMapper = authenticationRequestMapper;
        this.userMapper = userMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public UserRegistrationDTO registerUser(UserRegistrationDTO userRegistrationDTO) {
        User user = userRegistrationMapper.toUser(userRegistrationDTO);
        User addedUser = userService.registerUser(user);
        return userRegistrationMapper.toUserRegistrationDTO(addedUser);
    }

    @Override
    public String loginUser(AuthenticationRequestDTO authenticationRequestDTO) {
        User user = authenticationRequestMapper.toUser(authenticationRequestDTO);
        return userService.loginUser(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> receivedUsers = userService.getAllUsers();
        return userMapper.toUserDTOs(receivedUsers);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User receivedUser = userService.getUserById(userId);
        return userMapper.toUserDTO(receivedUser);
    }

    @Override
    public void updatePassword(Long userId, String newPassword) {
        userService.updatePassword(userId, newPassword);
    }

    @Override
    public void addOrder(Long userId, OrderDTO orderDTO) {
        Order order = orderMapper.toOrder(orderDTO);
        userService.addOrder(userId, order);
    }

    @Override
    public void cancelOrder(Long userId, Long orderId) {
        userService.cancelOrder(userId, orderId);
    }
}
