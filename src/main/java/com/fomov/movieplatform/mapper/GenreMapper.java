package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.GenreDTO;
import com.fomov.movieplatform.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = MovieMapper.class)
public interface GenreMapper {

    @Mapping(source = "movies", target = "movieDTOs")
    GenreDTO genreToGenreDTO(Genre genre);

    @Mapping(source = "movieDTOs", target = "movies")
    Genre genreDTOToGenre(GenreDTO genreDTO);

    List<GenreDTO> genresToGenreDTOs(List<Genre> genres);

    List<Genre> genreDTOsToGenres(List<GenreDTO> genreDTOs);
}


