package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.GenreDTO;
import com.fomov.movieplatform.model.Genre;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    GenreDTO toGenreDTO(Genre genre);

    Genre toGenre(GenreDTO genreDTO);

    @IterableMapping(elementTargetType = GenreDTO.class)
    List<GenreDTO> toGenreDTOs(List<Genre> genres);

    @IterableMapping(elementTargetType = Genre.class)
    List<Genre> toGenres(List<GenreDTO> genreDTOs);
}


