package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.UserDTO;
import com.fomov.movieplatform.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "orderDTOs", source = "orders")
    UserDTO toUserDTO(User user);

    @Mapping(target = "orders", source = "orderDTOs")
    User toUser(UserDTO userDTO);

    @IterableMapping(elementTargetType = UserDTO.class)
    List<UserDTO> toUserDTOs(List<User> users);

    @IterableMapping(elementTargetType = User.class)
    List<User> toUsers(List<UserDTO> userDTOs);
}
