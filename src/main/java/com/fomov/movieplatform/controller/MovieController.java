package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.MovieDTO;
import com.fomov.movieplatform.exception.notfound.MovieNotFoundException;
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
    ResponseEntity<?> getAllMovies() {
        try {
            List<MovieDTO> movieDTOs = movieFacade.getAllMovies();
            return ResponseEntity.ok(movieDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable Long movieId) {
        try {
            MovieDTO movieDTO = movieFacade.getMovieById(movieId);
            return ResponseEntity.ok(movieDTO);
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    ResponseEntity<?> addMovie(@RequestBody MovieDTO movieDTO) {
        try {
            MovieDTO addedMovie = movieFacade.addMovie(movieDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedMovie);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long movieId) {
        try {
            movieFacade.deleteMovie(movieId);
            return ResponseEntity.ok("Movie successfully deleted.");
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<?> updateMovie(@PathVariable Long movieId, @RequestBody MovieDTO movieDTO) {
        try {
            MovieDTO updatedMovie = movieFacade.updateMovie(movieId, movieDTO);
            return ResponseEntity.ok(updatedMovie);
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
