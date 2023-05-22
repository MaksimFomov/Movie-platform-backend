package com.fomov.movieplatform.service.impl;

import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.exception.cinema.CinemaNotFoundException;
import com.fomov.movieplatform.exception.movie.MovieNotFoundException;
import com.fomov.movieplatform.model.Movie;
import com.fomov.movieplatform.model.MovieDetails;
import com.fomov.movieplatform.repository.GenreRepository;
import com.fomov.movieplatform.repository.MovieRepository;
import com.fomov.movieplatform.service.MovieService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public MovieServiceImpl(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    @Transactional
    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Transactional
    @Override
    public void deleteMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with ID: " + movieId));

        movieRepository.delete(movie);
    }

    @Transactional
    @Override
    public Movie updateMovie(Long movieId, Movie movie) {
        Movie updatedMovie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with ID: " + movieId));

        updatedMovie.setName(movie.getName());
        MovieDetails updatedMovieDetails = updatedMovie.getMovieDetails();
        updatedMovieDetails.setDescription(movie.getMovieDetails().getDescription());
        updatedMovieDetails.setCountry(movie.getMovieDetails().getCountry());
        updatedMovieDetails.setYear(movie.getMovieDetails().getYear());
        updatedMovieDetails.setProducer(movie.getMovieDetails().getProducer());
        updatedMovieDetails.setDuration(movie.getMovieDetails().getDuration());
        updatedMovieDetails.setAgeLimit(movie.getMovieDetails().getAgeLimit());
        updatedMovie.setMovieDetails(updatedMovieDetails);
        updatedMovie.setGenre(genreRepository.findByName(movie.getGenre().getName()));

        return movieRepository.save(updatedMovie);
    }
}
