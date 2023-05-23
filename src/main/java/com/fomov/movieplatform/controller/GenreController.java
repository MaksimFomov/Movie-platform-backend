package com.fomov.movieplatform.controller;

import com.fomov.movieplatform.dto.GenreDTO;
import com.fomov.movieplatform.exception.notfound.GenreNotFoundException;
import com.fomov.movieplatform.facade.GenreFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    private final GenreFacade genreFacade;

    public GenreController(GenreFacade genreFacade) {
        this.genreFacade = genreFacade;
    }

    @GetMapping
    ResponseEntity<List<GenreDTO>> getAllGenres() {
        try {
            List<GenreDTO> genreDTOs = genreFacade.getAllGenres();
            return ResponseEntity.ok(genreDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{genreId}")
    public ResponseEntity<GenreDTO> getGenreById(@PathVariable Long genreId) {
        try {
            GenreDTO genreDTO = genreFacade.getGenreById(genreId);
            return ResponseEntity.ok(genreDTO);
        } catch (GenreNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    ResponseEntity<GenreDTO> addGenre(@RequestBody GenreDTO genreDTO) {
        try {
            GenreDTO addedGenre = genreFacade.addGenre(genreDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedGenre);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{genreId}")
    public ResponseEntity<String> deleteGenre(@PathVariable Long genreId) {
        try {
            genreFacade.deleteGenre(genreId);
            return ResponseEntity.ok("Genre successfully deleted.");
        } catch (GenreNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{genreId}")
    public ResponseEntity<GenreDTO> updateGenre(@PathVariable Long genreId, @RequestBody GenreDTO genreDTO) {
        try {
            GenreDTO updatedGenre = genreFacade.updateGenre(genreId, genreDTO);
            return ResponseEntity.ok(updatedGenre);
        } catch (GenreNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
