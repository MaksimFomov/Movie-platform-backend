package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.AuthenticationResponseDTO;
import com.fomov.movieplatform.dto.OrderRequestDTO;
import com.fomov.movieplatform.dto.UserRequestDTO;
import com.fomov.movieplatform.dto.UserResponseDTO;

import java.util.List;

public interface UserFacade {
    void registerUser(UserRequestDTO userRequestDTO);
    AuthenticationResponseDTO loginUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long userId);
    void updatePassword(Long userId, String newPassword);
    void addOrder(Long userId, OrderRequestDTO orderRequestDTO);
    void cancelOrder(Long userId, Long orderId);
}
