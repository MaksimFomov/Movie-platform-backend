package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.OrderDTO;
import com.fomov.movieplatform.dto.UserDTO;
import com.fomov.movieplatform.model.Order;
import com.fomov.movieplatform.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "orderDTOs", ignore = true)
    })
    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);

    default List<Order> toOrders(List<OrderDTO> orderDTOs) {
        return orderDTOs.stream()
                .map(OrderMapper.INSTANCE::toOrder)
                .collect(Collectors.toList());
    }
}

