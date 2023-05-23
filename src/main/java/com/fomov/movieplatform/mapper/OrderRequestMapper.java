package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.OrderRequestDTO;
import com.fomov.movieplatform.model.Order;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderRequestMapper {
    OrderRequestMapper INSTANCE = Mappers.getMapper(OrderRequestMapper.class);

    @Mapping(target = "eventId", source = "event.id")
    @Mapping(target = "userId", source = "user.id")
    OrderRequestDTO toOrderRequestDTO(Order order);

    @Mapping(target = "event.id", source = "eventId")
    @Mapping(target = "user.id", source = "userId")
    Order toOrder(OrderRequestDTO orderRequestDTO);

    @IterableMapping(elementTargetType = OrderRequestDTO.class)
    List<OrderRequestDTO> toOrderRequestDTOs(List<Order> orders);

    @IterableMapping(elementTargetType = Order.class)
    List<Order> toOrders(List<OrderRequestDTO> orderRequestDTOs);
}

