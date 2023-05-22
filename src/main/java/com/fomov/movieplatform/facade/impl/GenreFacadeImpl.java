package com.fomov.movieplatform.facade.impl;

import com.fomov.movieplatform.dto.GenreDTO;
import com.fomov.movieplatform.facade.GenreFacade;
import com.fomov.movieplatform.mapper.GenreMapper;
import com.fomov.movieplatform.model.Genre;
import com.fomov.movieplatform.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreFacadeImpl implements GenreFacade {
    private final GenreService genreService;
    private final GenreMapper genreMapper;

    public GenreFacadeImpl(GenreService genreService, GenreMapper genreMapper) {
        this.genreService = genreService;
        this.genreMapper = genreMapper;
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        List<Genre> receivedGenres = genreService.getAllGenres();
        return genreMapper.toGenreDTOs(receivedGenres);
    }

    @Override
    public GenreDTO getGenreById(Long genreId) {
        Genre receivedGenre = genreService.getGenreById(genreId);
        return genreMapper.toGenreDTO(receivedGenre);
    }

    @Override
    public GenreDTO addGenre(GenreDTO genreDTO) {
        Genre genre = genreMapper.toGenre(genreDTO);
        Genre addedGenre = genreService.addGenre(genre);
        return genreMapper.toGenreDTO(addedGenre);
    }

    @Override
    public void deleteGenre(Long genreId) {
        genreService.deleteGenre(genreId);
    }

    @Override
    public GenreDTO updateGenre(Long genreId, GenreDTO genreDTO) {
        Genre genre = genreMapper.toGenre(genreDTO);
        Genre updatedGenre = genreService.updateGenre(genreId, genre);
        return genreMapper.toGenreDTO(updatedGenre);
    }
}
