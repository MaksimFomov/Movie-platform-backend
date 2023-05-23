package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.EventResponseDTO;
import com.fomov.movieplatform.dto.OrderResponseDTO;
import com.fomov.movieplatform.model.Order;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserResponseMapper.class, EventResponseDTO.class})
public interface OrderResponseMapper {
    OrderResponseMapper INSTANCE = Mappers.getMapper(OrderResponseMapper.class);

    @Mapping(target = "userResponseDTO", source = "user")
    @Mapping(target = "eventResponseDTO", source = "event")
    OrderResponseDTO toOrderResponseDTO(Order order);

    @Mapping(target = "user", source = "userResponseDTO")
    @Mapping(target = "event", source = "eventResponseDTO")
    Order toOrder(OrderResponseDTO orderResponseDTO);

    @IterableMapping(elementTargetType = OrderResponseDTO.class)
    List<OrderResponseDTO> toOrderResponseDTOs(List<Order> orders);

    @IterableMapping(elementTargetType = Order.class)
    List<Order> toOrders(List<OrderResponseDTO> orderResponseDTOs);
}
