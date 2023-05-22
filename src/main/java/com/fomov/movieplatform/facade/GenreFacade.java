package com.fomov.movieplatform.facade;

import com.fomov.movieplatform.dto.GenreDTO;

import java.util.List;

public interface GenreFacade {
    List<GenreDTO> getAllGenres();
    GenreDTO getGenreById(Long genreId);

    GenreDTO addGenre(GenreDTO genreDTO);
    void deleteGenre(Long genreId);
    GenreDTO updateGenre(Long genreId, GenreDTO genreDTO);
}
