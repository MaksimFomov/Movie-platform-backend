package com.fomov.movieplatform.mapper.impl;

import com.fomov.movieplatform.dto.GenreDTO;
import com.fomov.movieplatform.mapper.GenreMapper;
import com.fomov.movieplatform.mapper.MovieMapper;
import com.fomov.movieplatform.model.Genre;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreMapperImpl implements GenreMapper {

    private final MovieMapper movieMapper;

    public GenreMapperImpl(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    @Override
    public GenreDTO genreToGenreDTO(Genre genre) {
        if (genre == null) {
            return null;
        }

        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        genreDTO.setMovieDTOs(movieMapper.moviesToMovieDTOs(genre.getMovies()));

        return genreDTO;
    }

    @Override
    public Genre genreDTOToGenre(GenreDTO genreDTO) {
        if (genreDTO == null) {
            return null;
        }

        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        genre.setMovies(movieMapper.movieDTOsToMovies(genreDTO.getMovieDTOs()));

        return genre;
    }

    @Override
    public List<GenreDTO> genresToGenreDTOs(List<Genre> genres) {
        if (genres == null) {
            return null;
        }

        return genres.stream()
                .map(this::genreToGenreDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Genre> genreDTOsToGenres(List<GenreDTO> genreDTOs) {
        if (genreDTOs == null) {
            return null;
        }

        return genreDTOs.stream()
                .map(this::genreDTOToGenre)
                .collect(Collectors.toList());
    }
}

