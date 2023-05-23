package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.AuthenticationRequestDTO;
import com.fomov.movieplatform.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthenticationRequestMapper {
    AuthenticationRequestMapper INSTANCE = Mappers.getMapper(AuthenticationRequestMapper.class);

    AuthenticationRequestDTO toUserAuthenticationRequestDTO(User user);

    User toUser(AuthenticationRequestDTO authenticationRequestDTO);

    @IterableMapping(elementTargetType = AuthenticationRequestDTO.class)
    List<AuthenticationRequestDTO> toUserAuthenticationRequestDTOs(List<User> users);

    @IterableMapping(elementTargetType = User.class)
    List<User> toUsers(List<AuthenticationRequestDTO> authenticationRequestDTOs);
}
