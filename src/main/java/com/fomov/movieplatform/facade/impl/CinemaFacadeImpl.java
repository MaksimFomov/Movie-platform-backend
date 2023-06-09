package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.facade.CinemaFacade;
import com.fomov.movieplatform.mapper.CinemaMapper;
import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaFacadeImpl implements CinemaFacade {
    private final CinemaService cinemaService;
    private final CinemaMapper cinemaMapper;

    public CinemaFacadeImpl(CinemaService cinemaService, CinemaMapper cinemaMapper) {
        this.cinemaService = cinemaService;
        this.cinemaMapper = cinemaMapper;
    }

    @Override
    public List<CinemaDTO> getAllCinemas() {
        List<Cinema> receivedCinemas = cinemaService.getAllCinemas();
        return cinemaMapper.toCinemaDTOs(receivedCinemas);
    }

    @Override
    public CinemaDTO getCinemaById(Long cinemaId) {
        Cinema receivedCinema = cinemaService.getCinemaById(cinemaId);
        return cinemaMapper.toCinemaDTO(receivedCinema);
    }

    @Override
    public CinemaDTO addCinema(CinemaDTO cinemaDTO) {
        Cinema cinema = cinemaMapper.toCinema(cinemaDTO);
        Cinema addedCinema = cinemaService.addCinema(cinema);
        return cinemaMapper.toCinemaDTO(addedCinema);
    }

    @Override
    public void deleteCinema(Long cinemaId) {
        cinemaService.deleteCinema(cinemaId);
    }

    @Override
    public CinemaDTO updateCinema(Long cinemaId, CinemaDTO cinemaDTO) {
        Cinema cinema = cinemaMapper.toCinema(cinemaDTO);
        Cinema updatedCinema = cinemaService.updateCinema(cinemaId, cinema);
        return cinemaMapper.toCinemaDTO(updatedCinema);
    }

    @Override
    public void addMovieToCinema(Long cinemaId, Long movieId) {
        cinemaService.addMovieToCinema(cinemaId, movieId);
    }

    @Override
    public boolean isMovieAlreadyAdded(Long cinemaId, Long movieId) {
        return cinemaService.isMovieAlreadyAdded(cinemaId, movieId);
    }

    @Override
    public void deleteMovieFromCinema(Long cinemaId, Long movieId) {
        cinemaService.deleteMovieFromCinema(cinemaId, movieId);
    }
}
