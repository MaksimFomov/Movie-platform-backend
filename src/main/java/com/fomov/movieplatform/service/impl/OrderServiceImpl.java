package com.fomov.movieplatform.service.impl;

import com.fomov.movieplatform.exception.notfound.OrderNotFoundException;
import com.fomov.movieplatform.model.Order;
import com.fomov.movieplatform.repository.OrderRepository;
import com.fomov.movieplatform.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + orderId));
    }
}
