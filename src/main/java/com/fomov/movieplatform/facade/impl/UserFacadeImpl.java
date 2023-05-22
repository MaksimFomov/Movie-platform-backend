package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.UserRegistrationDTO;
import com.fomov.movieplatform.facade.UserFacade;
import com.fomov.movieplatform.mapper.UserRegistrationMapper;
import com.fomov.movieplatform.model.User;
import com.fomov.movieplatform.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final UserRegistrationMapper userRegistrationMapper;

    public UserFacadeImpl(UserService userService, UserRegistrationMapper userRegistrationMapper) {
        this.userService = userService;
        this.userRegistrationMapper = userRegistrationMapper;
    }

    @Override
    public UserRegistrationDTO registerUser(UserRegistrationDTO userRegistrationDTO) {
        User user = userRegistrationMapper.toUser(userRegistrationDTO);
        User addedUser = userService.registerUser(user);
        return userRegistrationMapper.toUserRegistrationDTO(addedUser);
    }
}
