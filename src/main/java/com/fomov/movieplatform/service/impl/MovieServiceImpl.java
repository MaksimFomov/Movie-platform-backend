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
    public Movie updateMovie(Long movieId, MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with ID: " + movieId));

        movie.setName(movieDTO.getName());
        MovieDetails movieDetails = movie.getMovieDetails();
        movieDetails.setDescription(movieDTO.getDescription());
        movieDetails.setCountry(movieDTO.getCountry());
        movieDetails.setYear(movieDTO.getYear());
        movieDetails.setProducer(movieDTO.getProducer());
        movieDetails.setDuration(movieDTO.getDuration());
        movieDetails.setAgeLimit(movieDTO.getAgeLimit());
        movie.setMovieDetails(movieDetails);
        movie.setGenre(genreRepository.findByName(movieDTO.getGenreName()));

        return movieRepository.save(movie);
    }
}
