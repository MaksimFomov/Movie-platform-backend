package com.fomov.movieplatform.service;

import com.fomov.movieplatform.model.Cinema;

import java.util.List;

public interface CinemaService {
    List<Cinema> getAllCinemas();
    Cinema getCinemaById(Long id);
    Cinema addCinema(Cinema cinema);
}
