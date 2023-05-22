package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.dto.UserDTO;
import com.fomov.movieplatform.dto.UserRegistrationDTO;

public interface UserFacade {
    UserRegistrationDTO registerUser(UserRegistrationDTO userRegistrationDTO);
}
