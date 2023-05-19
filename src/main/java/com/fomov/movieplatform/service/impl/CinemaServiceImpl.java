package com.fomov.movieplatform.service.impl;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.repository.CinemaRepository;
import com.fomov.movieplatform.service.CinemaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Transactional
    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @Transactional
    @Override
    public Cinema getCinemaById(Long id) {
        return cinemaRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Cinema addCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }
}
