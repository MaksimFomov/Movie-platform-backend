package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.UserResponseDTO;
import com.fomov.movieplatform.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T10:21:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Azul Systems, Inc.)"
)
@Component
public class UserResponseMapperImpl implements UserResponseMapper {

    @Autowired
    private OrderRequestMapper orderRequestMapper;

    @Override
    public UserResponseDTO toUserResponseDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setOrders( orderRequestMapper.toOrderRequestDTOs( user.getOrders() ) );
        if ( user.getId() != null ) {
            userResponseDTO.setId( user.getId() );
        }
        userResponseDTO.setUsername( user.getUsername() );
        userResponseDTO.setRole( user.getRole() );

        return userResponseDTO;
    }

    @Override
    public User toUser(UserResponseDTO userResponseDTO) {
        if ( userResponseDTO == null ) {
            return null;
        }

        User user = new User();

        user.setOrders( orderRequestMapper.toOrders( userResponseDTO.getOrders() ) );
        user.setId( userResponseDTO.getId() );
        user.setUsername( userResponseDTO.getUsername() );
        user.setRole( userResponseDTO.getRole() );

        return user;
    }

    @Override
    public List<UserResponseDTO> toUserResponseDTOs(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponseDTO> list = new ArrayList<UserResponseDTO>( users.size() );
        for ( User user : users ) {
            list.add( toUserResponseDTO( user ) );
        }

        return list;
    }

    @Override
    public List<User> toUsers(List<UserResponseDTO> userResponseDTOS) {
        if ( userResponseDTOS == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userResponseDTOS.size() );
        for ( UserResponseDTO userResponseDTO : userResponseDTOS ) {
            list.add( toUser( userResponseDTO ) );
        }

        return list;
    }
}
