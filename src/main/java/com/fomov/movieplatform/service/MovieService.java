package com.fomov.movieplatform.service;

import com.fomov.movieplatform.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(Long movieId);

    Movie addMovie(Movie movie);
    void deleteMovie(Long movieId);
    Movie updateMovie(Long movieId, Movie movie);
}
