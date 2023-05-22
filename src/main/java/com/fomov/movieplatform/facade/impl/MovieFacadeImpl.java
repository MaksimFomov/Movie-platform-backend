package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.facade.MovieFacade;
import com.fomov.movieplatform.mapper.MovieMapper;
import com.fomov.movieplatform.model.Movie;
import com.fomov.movieplatform.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieFacadeImpl implements MovieFacade {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieFacadeImpl(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> receivedMovies = movieService.getAllMovies();
        return movieMapper.toMovieDTOs(receivedMovies);
    }

    @Override
    public MovieDTO getMovieById(Long movieId) {
        Movie receivedMovie = movieService.getMovieById(movieId);
        return movieMapper.toMovieDTO(receivedMovie);
    }

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movie = movieMapper.toMovie(movieDTO);
        Movie addedMovie = movieService.addMovie(movie);
        return movieMapper.toMovieDTO(addedMovie);
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieService.deleteMovie(movieId);
    }

    @Override
    public MovieDTO updateMovie(Long movieId, MovieDTO movieDTO) {
        Movie movie = movieMapper.toMovie(movieDTO);
        Movie updatedMovie = movieService.updateMovie(movieId, movie);
        return movieMapper.toMovieDTO(updatedMovie);
    }
}
