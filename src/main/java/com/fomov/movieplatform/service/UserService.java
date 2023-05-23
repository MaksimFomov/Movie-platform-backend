package com.fomov.movieplatform.service;

import com.fomov.movieplatform.model.Order;
import com.fomov.movieplatform.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    String loginUser(User user);
    List<User> getAllUsers();
    User getUserById(Long userId);
    void updatePassword(Long userId, String newPassword);
    void addOrder(Long userId, Order order);
    void cancelOrder(Long userId, Long orderId);
}
