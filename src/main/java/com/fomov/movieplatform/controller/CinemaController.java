package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.exception.notfound.CinemaNotFoundException;
import com.fomov.movieplatform.exception.notfound.MovieNotFoundException;
import com.fomov.movieplatform.facade.CinemaFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {
    private final CinemaFacade cinemaFacade;

    public CinemaController(CinemaFacade cinemaFacade) {
        this.cinemaFacade = cinemaFacade;
    }

    @GetMapping
    ResponseEntity<?> getAllCinemas() {
        try {
            List<CinemaDTO> cinemaDTOs = cinemaFacade.getAllCinemas();
            return ResponseEntity.ok(cinemaDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{cinemaId}")
    public ResponseEntity<?> getCinemaById(@PathVariable Long cinemaId) {
        try {
            CinemaDTO cinemaDTO = cinemaFacade.getCinemaById(cinemaId);
            return ResponseEntity.ok(cinemaDTO);
        } catch (CinemaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    ResponseEntity<?> addCinema(@RequestBody CinemaDTO cinemaDTO) {
        try {
            CinemaDTO addedCinema = cinemaFacade.addCinema(cinemaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedCinema);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{cinemaId}")
    public ResponseEntity<String> deleteCinema(@PathVariable Long cinemaId) {
        try {
            cinemaFacade.deleteCinema(cinemaId);
            return ResponseEntity.ok("Cinema successfully deleted.");
        } catch (CinemaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{cinemaId}")
    public ResponseEntity<?> updateCinema(@PathVariable Long cinemaId, @RequestBody CinemaDTO cinemaDTO) {
        try {
            CinemaDTO updatedCinema = cinemaFacade.updateCinema(cinemaId, cinemaDTO);
            return ResponseEntity.ok(updatedCinema);
        } catch (CinemaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{cinemaId}/movies/{movieId}")
    public ResponseEntity<String> addMovieToCinema(
            @PathVariable Long cinemaId,
            @PathVariable Long movieId
    ) {
        if (cinemaFacade.isMovieAlreadyAdded(cinemaId, movieId)) {
            return ResponseEntity.badRequest().body("Movie already added to the cinema.");
        }

        try {
            cinemaFacade.addMovieToCinema(cinemaId, movieId);

            return ResponseEntity.ok("Movie added to cinema successfully.");
        } catch (CinemaNotFoundException | MovieNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{cinemaId}/movies/{movieId}")
    public ResponseEntity<String> deleteMovieFromCinema(
            @PathVariable Long cinemaId,
            @PathVariable Long movieId
    ) {
        try {
            cinemaFacade.deleteMovieFromCinema(cinemaId, movieId);
            return ResponseEntity.ok("Movie successfully removed from cinema.");
        } catch (CinemaNotFoundException | MovieNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
