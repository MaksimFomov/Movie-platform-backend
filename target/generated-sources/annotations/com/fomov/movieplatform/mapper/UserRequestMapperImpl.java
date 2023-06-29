package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.UserRequestDTO;
import com.fomov.movieplatform.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T10:21:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Azul Systems, Inc.)"
)
@Component
public class UserRequestMapperImpl implements UserRequestMapper {

    @Override
    public UserRequestDTO toUserRequestDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserRequestDTO userRequestDTO = new UserRequestDTO();

        userRequestDTO.setUsername( user.getUsername() );
        userRequestDTO.setPassword( user.getPassword() );

        return userRequestDTO;
    }

    @Override
    public User toUser(UserRequestDTO userRequestDTO) {
        if ( userRequestDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userRequestDTO.getUsername() );
        user.setPassword( userRequestDTO.getPassword() );

        return user;
    }

    @Override
    public List<UserRequestDTO> toUserRequestDTOs(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserRequestDTO> list = new ArrayList<UserRequestDTO>( users.size() );
        for ( User user : users ) {
            list.add( toUserRequestDTO( user ) );
        }

        return list;
    }

    @Override
    public List<User> toUsers(List<UserRequestDTO> userRequestDTOs) {
        if ( userRequestDTOs == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userRequestDTOs.size() );
        for ( UserRequestDTO userRequestDTO : userRequestDTOs ) {
            list.add( toUser( userRequestDTO ) );
        }

        return list;
    }
}
