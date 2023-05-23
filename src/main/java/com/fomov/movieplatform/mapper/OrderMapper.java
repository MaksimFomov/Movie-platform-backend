package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.OrderDTO;
import com.fomov.movieplatform.model.Order;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = EventMapper.class)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "eventId", source = "event.id")
    @Mapping(target = "userId", source = "user.id")
    OrderDTO toOrderDTO(Order order);

    @Mapping(target = "event.id", source = "eventId")
    @Mapping(target = "user.id", source = "userId")
    Order toOrder(OrderDTO orderDTO);

    @IterableMapping(elementTargetType = OrderDTO.class)
    List<OrderDTO> toOrderDTOs(List<Order> orders);

    @IterableMapping(elementTargetType = Order.class)
    List<Order> toOrders(List<OrderDTO> orderDTOs);
}

