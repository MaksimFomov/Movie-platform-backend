package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.OrderDTO;
import com.fomov.movieplatform.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, EventMapper.class})
public interface OrderMapper {

    @Mapping(source = "user", target = "userDTO")
    @Mapping(source = "event", target = "eventDTO")
    OrderDTO orderToOrderDTO(Order order);

    @Mapping(source = "userDTO", target = "user")
    @Mapping(source = "eventDTO", target = "event")
    Order orderDTOToOrder(OrderDTO orderDTO);

    List<OrderDTO> ordersToOrderDTOs(List<Order> orders);

    List<Order> orderDTOsToOrders(List<OrderDTO> orderDTOs);
}

