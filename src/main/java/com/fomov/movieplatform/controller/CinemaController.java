package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.CinemaDTO;
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
    ResponseEntity<List<CinemaDTO>> getAllCinemas() {
        List<CinemaDTO> cinemaDTOs = cinemaFacade.getAllCinemas();
        return ResponseEntity.ok(cinemaDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CinemaDTO> getCinemaById(@PathVariable Long id) {
        CinemaDTO cinemaDTO = cinemaFacade.getCinemaById(id);
        if (cinemaDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cinemaDTO);
    }

    @PostMapping
    ResponseEntity<CinemaDTO> addCinema(@RequestBody CinemaDTO cinemaDTO) {
        CinemaDTO addedCinema = cinemaFacade.addCinema(cinemaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCinema);
    }
}
