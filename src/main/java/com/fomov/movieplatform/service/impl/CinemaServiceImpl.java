package com.fomov.movieplatform.service.impl;

import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.repository.CinemaRepository;
import com.fomov.movieplatform.service.CinemaService;
import jakarta.transaction.Transactional;

public record CinemaServiceImpl(CinemaRepository cinemaRepository) implements CinemaService {
    @Transactional
    @Override
    public Cinema addCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }
}
