package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.CinemaDTO;

import java.util.List;

public interface CinemaFacade {
    List<CinemaDTO> getAllCinemas();
    CinemaDTO getCinemaById(Long id);

    CinemaDTO addCinema(CinemaDTO cinemaDTO);
    void deleteCinema(Long cinemaId);
    CinemaDTO updateCinema(Long cinemaId, CinemaDTO cinemaDTO);

    void addMovieToCinema(Long cinemaId, Long movieId);
    boolean isMovieAlreadyAdded(Long cinemaId, Long movieId);
    void deleteMovieFromCinema(Long cinemaId, Long movieId);
}
