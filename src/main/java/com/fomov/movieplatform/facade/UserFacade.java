package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.AuthenticationRequestDTO;
import com.fomov.movieplatform.dto.UserRegistrationDTO;

public interface UserFacade {
    UserRegistrationDTO registerUser(UserRegistrationDTO userRegistrationDTO);
    String loginUser(AuthenticationRequestDTO authenticationRequestDTO);
}
