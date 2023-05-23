package com.fomov.movieplatform.service.impl;

import com.fomov.movieplatform.exception.notfound.CinemaNotFoundException;
import com.fomov.movieplatform.exception.notfound.MovieNotFoundException;
import com.fomov.movieplatform.model.Cinema;
import com.fomov.movieplatform.model.CinemaDetails;
import com.fomov.movieplatform.model.Movie;
import com.fomov.movieplatform.repository.CinemaRepository;
import com.fomov.movieplatform.repository.MovieRepository;
import com.fomov.movieplatform.service.CinemaService;
import javax.transaction.Transactional;
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

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema getCinemaById(Long cinemaId) {
        return cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new CinemaNotFoundException("Cinema not found with ID: " + cinemaId));
    }

    @Transactional
    @Override
    public Cinema addCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Transactional
    @Override
    public void deleteCinema(Long cinemaId) {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new CinemaNotFoundException("Cinema not found with ID: " + cinemaId));

        cinemaRepository.delete(cinema);
    }

    @Transactional
    @Override
    public Cinema updateCinema(Long cinemaId, Cinema cinema) {
        Cinema updatedCinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new CinemaNotFoundException("Cinema not found with ID: " + cinemaId));

        updatedCinema.setName(cinema.getName());
        CinemaDetails updatedCinemaDetails = updatedCinema.getCinemaDetails();
        updatedCinemaDetails.setAddress(cinema.getCinemaDetails().getAddress());
        updatedCinemaDetails.setCapacity(cinema.getCinemaDetails().getCapacity());
        updatedCinema.setCinemaDetails(updatedCinemaDetails);

        return cinemaRepository.save(updatedCinema);
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
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with ID: " + movieId));
        return cinema != null && movie != null && cinema.getMovies().contains(movie);
    }

    @Transactional
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
