package com.fomov.movieplatform.service;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.model.Cinema;

import java.util.List;

public interface CinemaService {
    List<Cinema> getAllCinemas();
    Cinema getCinemaById(Long cinemaId);

    Cinema addCinema(Cinema cinema);
    void deleteCinema(Long cinemaId);
    Cinema updateCinema(Long cinemaId, Cinema cinema);

    void addMovieToCinema(Long cinemaId, Long movieId);
    boolean isMovieAlreadyAdded(Long cinemaId, Long movieId);
    void deleteMovieFromCinema(Long cinemaId, Long movieId);
}
