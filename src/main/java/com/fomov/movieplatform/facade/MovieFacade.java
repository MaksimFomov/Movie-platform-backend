package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.MovieDTO;
import java.util.List;

public interface MovieFacade {
    List<MovieDTO> getAllMovies();
    MovieDTO getMovieById(Long movieId);

    MovieDTO addMovie(MovieDTO movieDTO);
    void deleteMovie(Long movieId);
    MovieDTO updateMovie(Long movieId, MovieDTO movieDTO);
}
