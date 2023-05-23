package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.UserResponseDTO;
import com.fomov.movieplatform.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface UserResponseMapper {
    UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

    @Mapping(target = "orderDTOs", source = "orders")
    UserResponseDTO toUserResponseDTO(User user);

    @Mapping(target = "orders", source = "orderDTOs")
    User toUser(UserResponseDTO userResponseDTO);

    @IterableMapping(elementTargetType = UserResponseDTO.class)
    List<UserResponseDTO> toUserResponseDTOs(List<User> users);

    @IterableMapping(elementTargetType = User.class)
    List<User> toUsers(List<UserResponseDTO> userResponseDTOS);
}
