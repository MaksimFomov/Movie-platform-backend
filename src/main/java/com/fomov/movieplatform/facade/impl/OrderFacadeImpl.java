package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.OrderDTO;
import com.fomov.movieplatform.facade.OrderFacade;
import com.fomov.movieplatform.mapper.OrderMapper;
import com.fomov.movieplatform.model.Order;
import com.fomov.movieplatform.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFacadeImpl implements OrderFacade {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderFacadeImpl(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> receivedOrders = orderService.getAllOrders();
        return orderMapper.toOrderDTOs(receivedOrders);
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        Order receivedOrder = orderService.getOrderById(orderId);
        return orderMapper.toOrderDTO(receivedOrder);
    }
}
