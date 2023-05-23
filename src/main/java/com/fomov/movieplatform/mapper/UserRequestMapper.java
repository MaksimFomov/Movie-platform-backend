package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.UserRequestDTO;
import com.fomov.movieplatform.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);

    UserRequestDTO toUserRequestDTO(User user);

    User toUser(UserRequestDTO userRequestDTO);

    @IterableMapping(elementTargetType = UserRequestDTO.class)
    List<UserRequestDTO> toUserRequestDTOs(List<User> users);

    @IterableMapping(elementTargetType = User.class)
    List<User> toUsers(List<UserRequestDTO> userRequestDTOs);
}
