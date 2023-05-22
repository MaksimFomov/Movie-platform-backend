package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.UserRegistrationDTO;
import com.fomov.movieplatform.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRegistrationMapper {
    UserRegistrationMapper INSTANCE = Mappers.getMapper(UserRegistrationMapper.class);

    UserRegistrationDTO toUserRegistrationDTO(User user);

    User toUser(UserRegistrationDTO userRegistrationDTO);

    @IterableMapping(elementTargetType = UserRegistrationDTO.class)
    List<UserRegistrationDTO> toUserRegistrationDTOs(List<User> users);

    @IterableMapping(elementTargetType = User.class)
    List<User> toUsers(List<UserRegistrationDTO> userRegistrationDTOs);
}
