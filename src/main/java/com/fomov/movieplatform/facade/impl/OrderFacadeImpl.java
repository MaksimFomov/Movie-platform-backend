package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.OrderResponseDTO;
import com.fomov.movieplatform.facade.OrderFacade;
import com.fomov.movieplatform.mapper.OrderResponseMapper;
import com.fomov.movieplatform.model.Order;
import com.fomov.movieplatform.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFacadeImpl implements OrderFacade {
    private final OrderService orderService;
    private final OrderResponseMapper orderResponseMapper;

    public OrderFacadeImpl(OrderService orderService, OrderResponseMapper orderResponseMapper) {
        this.orderService = orderService;
        this.orderResponseMapper = orderResponseMapper;
    }

    @Override
    public List<OrderResponseDTO> getAllOrders() {
        List<Order> receivedOrders = orderService.getAllOrders();
        return orderResponseMapper.toOrderResponseDTOs(receivedOrders);
    }

    @Override
    public OrderResponseDTO getOrderById(Long orderId) {
        Order receivedOrder = orderService.getOrderById(orderId);
        return orderResponseMapper.toOrderResponseDTO(receivedOrder);
    }
}
