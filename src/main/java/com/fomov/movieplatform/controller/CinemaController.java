package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.CinemaDTO;
import com.fomov.movieplatform.facade.CinemaFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {
    private final CinemaFacade cinemaFacade;

    public CinemaController(CinemaFacade cinemaFacade) {
        this.cinemaFacade = cinemaFacade;
    }

    @PostMapping
    ResponseEntity<CinemaDTO> addCinema(@RequestBody CinemaDTO cinemaDTO) {
        CinemaDTO addedCinema = cinemaFacade.addCinema(cinemaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCinema);
    }
}
