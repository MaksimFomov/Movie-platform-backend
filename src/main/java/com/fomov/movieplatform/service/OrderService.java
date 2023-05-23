package com.fomov.movieplatform.service;

import com.fomov.movieplatform.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long orderId);
}
