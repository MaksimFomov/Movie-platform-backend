package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.facade.UserFacade;
import com.fomov.movieplatform.service.UserService;
import org.springframework.stereotype.Service;

@Service
public record UserFacadeImpl(UserService userService) implements UserFacade {

}
