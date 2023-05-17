package com.fomov.movieplatform.mapper.impl;

import com.fomov.movieplatform.dto.UserDTO;
import com.fomov.movieplatform.mapper.OrderMapper;
import com.fomov.movieplatform.mapper.UserMapper;
import com.fomov.movieplatform.model.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements UserMapper {

    private final OrderMapper orderMapper;

    public UserMapperImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public UserDTO userToUserDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setOrderDTOs(orderMapper.ordersToOrderDTOs(user.getOrders()));

        return userDTO;
    }

    @Override
    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setOrders(orderMapper.orderDTOsToOrders(userDTO.getOrderDTOs()));

        return user;
    }

    @Override
    public List<UserDTO> usersToUserDTOs(List<User> users) {
        if (users == null) {
            return Collections.emptyList();
        }

        return users.stream()
                .map(this::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> userDTOsToUsers(List<UserDTO> userDTOs) {
        if (userDTOs == null) {
            return Collections.emptyList();
        }

        return userDTOs.stream()
                .map(this::userDTOToUser)
                .collect(Collectors.toList());
    }
}

