package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.facade.CinemaFacade;
import com.fomov.movieplatform.mapper.CinemaMapper;
import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.service.CinemaService;
import org.springframework.stereotype.Service;

@Service
public class CinemaFacadeImpl implements CinemaFacade {
    private final CinemaService cinemaService;
    private final CinemaMapper cinemaMapper;

    public CinemaFacadeImpl(CinemaService cinemaService, CinemaMapper cinemaMapper) {
        this.cinemaService = cinemaService;
        this.cinemaMapper = cinemaMapper;
    }

    @Override
    public CinemaDTO addCinema(CinemaDTO cinemaDTO) {
        Cinema cinema = cinemaMapper.toCinema(cinemaDTO);
        Cinema addedCinema = cinemaService.addCinema(cinema);
        return cinemaMapper.toCinemaDTO(addedCinema);
    }
}
