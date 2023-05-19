package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.OrderDTO;
import com.fomov.movieplatform.model.Order;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "userDTO", ignore = true)
    @Mapping(target = "eventDTO", ignore = true)
    OrderDTO toOrderDTO(Order order);

    @AfterMapping
    default void setUserDTO(@MappingTarget OrderDTO orderDTO, Order order) {
        orderDTO.setUserDTO(UserMapper.INSTANCE.toUserDTO(order.getUser()));
    }

    @AfterMapping
    default void setEventDTO(@MappingTarget OrderDTO orderDTO, Order order) {
        orderDTO.setEventDTO(EventMapper.INSTANCE.toEventDTO(order.getEvent()));
    }

    Order toOrder(OrderDTO orderDTO);
}

