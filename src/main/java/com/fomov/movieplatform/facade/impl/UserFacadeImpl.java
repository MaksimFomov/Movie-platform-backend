package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.AuthenticationRequestDTO;
import com.fomov.movieplatform.dto.UserRegistrationDTO;
import com.fomov.movieplatform.facade.UserFacade;
import com.fomov.movieplatform.mapper.AuthenticationRequestMapper;
import com.fomov.movieplatform.mapper.UserRegistrationMapper;
import com.fomov.movieplatform.model.User;
import com.fomov.movieplatform.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final UserRegistrationMapper userRegistrationMapper;
    private final AuthenticationRequestMapper authenticationRequestMapper;

    public UserFacadeImpl(UserService userService, UserRegistrationMapper userRegistrationMapper, AuthenticationRequestMapper authenticationRequestMapper) {
        this.userService = userService;
        this.userRegistrationMapper = userRegistrationMapper;
        this.authenticationRequestMapper = authenticationRequestMapper;
    }

    @Override
    public UserRegistrationDTO registerUser(UserRegistrationDTO userRegistrationDTO) {
        User user = userRegistrationMapper.toUser(userRegistrationDTO);
        User addedUser = userService.registerUser(user);
        return userRegistrationMapper.toUserRegistrationDTO(addedUser);
    }

    @Override
    public String loginUser(AuthenticationRequestDTO authenticationRequestDTO) {
        User user = authenticationRequestMapper.toUser(authenticationRequestDTO);
        return userService.loginUser(user);
    }
}
