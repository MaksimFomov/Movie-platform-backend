package com.fomov.movieplatform.service.impl;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.exception.cinema.CinemaNotFoundException;
import com.fomov.movieplatform.exception.movie.MovieNotFoundException;
import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.model.CinemaDetails;
import com.fomov.movieplatform.model.Movie;
import com.fomov.movieplatform.repository.CinemaRepository;
import com.fomov.movieplatform.repository.MovieRepository;
import com.fomov.movieplatform.service.CinemaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository, MovieRepository movieRepository) {
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
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

    @Override
    public void deleteCinema(Long cinemaId) {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new CinemaNotFoundException("Cinema not found with ID: " + cinemaId));

        cinemaRepository.delete(cinema);
    }

    @Override
    public Cinema updateCinema(Long cinemaId, CinemaDTO cinemaDTO) {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new CinemaNotFoundException("Cinema not found with ID: " + cinemaId));

        cinema.setName(cinemaDTO.getName());
        CinemaDetails cinemaDetails = cinema.getCinemaDetails();
        cinemaDetails.setAddress(cinemaDTO.getAddress());
        cinemaDetails.setCapacity(cinemaDTO.getCapacity());
        cinema.setCinemaDetails(cinemaDetails);

        return cinemaRepository.save(cinema);
    }

    @Transactional
    @Override
    public void addMovieToCinema(Long cinemaId, Long movieId) {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new CinemaNotFoundException("Cinema not found with ID: " + cinemaId));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with ID: " + movieId));

        cinema.getMovies().add(movie);
        cinemaRepository.save(cinema);
    }

    @Override
    public boolean isMovieAlreadyAdded(Long cinemaId, Long movieId) {
        Cinema cinema = getCinemaById(cinemaId);
        Movie movie = movieRepository.findById(movieId).orElse(null);
        return cinema != null && movie != null && cinema.getMovies().contains(movie);
    }

    @Override
    public void deleteMovieFromCinema(Long cinemaId, Long movieId) {
        Cinema cinema = getCinemaById(cinemaId);
        Movie movie = movieRepository.findById(movieId).orElse(null);

        if (cinema == null) {
            throw new CinemaNotFoundException("Cinema not found with ID: " + cinemaId);
        }

        if (movie == null) {
            throw new MovieNotFoundException("Movie not found with ID: " + movieId);
        }

        if (!cinema.getMovies().contains(movie)) {
            throw new IllegalArgumentException("Movie is not associated with the cinema.");
        }

        cinema.getMovies().remove(movie);
        cinemaRepository.save(cinema);
    }
}
