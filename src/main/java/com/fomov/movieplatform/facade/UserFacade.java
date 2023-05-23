package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.AuthenticationRequestDTO;
import com.fomov.movieplatform.dto.OrderDTO;
import com.fomov.movieplatform.dto.UserDTO;
import com.fomov.movieplatform.dto.UserRegistrationDTO;

import java.util.List;

public interface UserFacade {
    UserRegistrationDTO registerUser(UserRegistrationDTO userRegistrationDTO);
    String loginUser(AuthenticationRequestDTO authenticationRequestDTO);

    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long userId);
    void updatePassword(Long userId, String newPassword);
    void addOrder(Long userId, OrderDTO orderDTO);
    void cancelOrder(Long userId, Long orderId);
}
