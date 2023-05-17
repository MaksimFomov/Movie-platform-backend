package com.fomov.movieplatform.mapper.impl;

import com.fomov.movieplatform.dto.OrderDTO;
import com.fomov.movieplatform.mapper.EventMapper;
import com.fomov.movieplatform.mapper.OrderMapper;
import com.fomov.movieplatform.mapper.UserMapper;
import com.fomov.movieplatform.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements OrderMapper {

    private final UserMapper userMapper;
    private final EventMapper eventMapper;

    public OrderMapperImpl(UserMapper userMapper, EventMapper eventMapper) {
        this.userMapper = userMapper;
        this.eventMapper = eventMapper;
    }

    @Override
    public OrderDTO orderToOrderDTO(Order order) {
        if (order == null) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setUserDTO(userMapper.userToUserDTO(order.getUser()));
        orderDTO.setEventDTO(eventMapper.eventToEventDTO(order.getEvent()));
        orderDTO.setPlace(order.getPlace());

        return orderDTO;
    }

    @Override
    public Order orderDTOToOrder(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }

        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setUser(userMapper.userDTOToUser(orderDTO.getUserDTO()));
        order.setEvent(eventMapper.eventDTOToEvent(orderDTO.getEventDTO()));
        order.setPlace(orderDTO.getPlace());

        return order;
    }

    @Override
    public List<OrderDTO> ordersToOrderDTOs(List<Order> orders) {
        if (orders == null) {
            return null;
        }

        return orders.stream()
                .map(this::orderToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> orderDTOsToOrders(List<OrderDTO> orderDTOs) {
        if (orderDTOs == null) {
            return null;
        }

        return orderDTOs.stream()
                .map(this::orderDTOToOrder)
                .collect(Collectors.toList());
    }
}


