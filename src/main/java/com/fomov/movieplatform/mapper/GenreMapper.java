package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.GenreDTO;
import com.fomov.movieplatform.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    GenreDTO toGenreDTO(Genre genre);

    Genre toGenre(GenreDTO genreDTO);
}


