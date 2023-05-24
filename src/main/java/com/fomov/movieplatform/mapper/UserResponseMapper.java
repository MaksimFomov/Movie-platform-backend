package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.UserResponseDTO;
import com.fomov.movieplatform.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderRequestMapper.class)
public interface UserResponseMapper {
    UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

    @Mapping(target = "orders", source = "orders")
    UserResponseDTO toUserResponseDTO(User user);

    @Mapping(target = "orders", source = "orders")
    User toUser(UserResponseDTO userResponseDTO);

    @IterableMapping(elementTargetType = UserResponseDTO.class)
    List<UserResponseDTO> toUserResponseDTOs(List<User> users);

    @IterableMapping(elementTargetType = User.class)
    List<User> toUsers(List<UserResponseDTO> userResponseDTOS);
}
