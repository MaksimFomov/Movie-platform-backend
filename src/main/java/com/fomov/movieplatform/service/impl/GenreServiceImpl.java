package com.fomov.movieplatform.service.impl;

import com.fomov.movieplatform.exception.notfound.GenreNotFoundException;
import com.fomov.movieplatform.model.Genre;
import com.fomov.movieplatform.repository.GenreRepository;
import com.fomov.movieplatform.service.GenreService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(Long genreId) {
        return genreRepository.findById(genreId)
                .orElseThrow(() -> new GenreNotFoundException("Genre not found with ID: " + genreId));
    }

    @Transactional
    @Override
    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Transactional
    @Override
    public void deleteGenre(Long genreId) {
        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new GenreNotFoundException("Genre not found with ID: " + genreId));

        genreRepository.delete(genre);
    }

    @Transactional
    @Override
    public Genre updateGenre(Long genreId, Genre genre) {
        Genre updatedGenre = genreRepository.findById(genreId)
                .orElseThrow(() -> new GenreNotFoundException("Genre not found with ID: " + genreId));

        updatedGenre.setName(genre.getName());

        return genreRepository.save(updatedGenre);
    }
}
