package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.CinemaDTO;

import java.util.List;

public interface CinemaFacade {
    List<CinemaDTO> getAllCinemas();
    CinemaDTO getCinemaById(Long id);
    CinemaDTO addCinema(CinemaDTO cinemaDTO);
}
