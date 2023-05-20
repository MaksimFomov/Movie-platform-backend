package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.exception.cinema.CinemaNotFoundException;
import com.fomov.movieplatform.exception.movie.MovieNotFoundException;
import com.fomov.movieplatform.facade.MovieFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieFacade movieFacade;

    public MovieController(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @GetMapping
    ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movieDTOs = movieFacade.getAllMovies();
        return ResponseEntity.ok(movieDTOs);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long movieId) {
        MovieDTO movieDTO = movieFacade.getMovieById(movieId);
        if (movieDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDTO);
    }

    @PostMapping
    ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO addedMovie = movieFacade.addMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedMovie);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long movieId) {
        try {
            movieFacade.deleteMovie(movieId);
            return ResponseEntity.ok("Movie successfully deleted.");
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable Long movieId, @RequestBody MovieDTO movieDTO) {
        try {
            MovieDTO updatedMovie = movieFacade.updateMovie(movieId, movieDTO);
            return ResponseEntity.ok(updatedMovie);
        } catch (MovieNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
