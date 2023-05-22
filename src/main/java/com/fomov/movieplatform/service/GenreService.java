package com.fomov.movieplatform.service;

import com.fomov.movieplatform.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();
    Genre getGenreById(Long genreId);

    Genre addGenre(Genre genre);
    void deleteGenre(Long genreId);
    Genre updateGenre(Long genreId, Genre genre);
}
