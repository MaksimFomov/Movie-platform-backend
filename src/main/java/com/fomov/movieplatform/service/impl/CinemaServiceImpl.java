package com.fomov.movieplatform.service.impl;

import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.repository.CinemaRepository;
import com.fomov.movieplatform.service.CinemaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Transactional
    @Override
    public Cinema addCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }
}
