package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.UserDTO;
import com.fomov.movieplatform.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface UserMapper {

    @Mapping(source = "orders", target = "orderDTOs")
    UserDTO userToUserDTO(User user);

    @Mapping(source = "orderDTOs", target = "orders")
    User userDTOToUser(UserDTO userDTO);

    List<UserDTO> usersToUserDTOs(List<User> users);

    List<User> userDTOsToUsers(List<UserDTO> userDTOs);
}

