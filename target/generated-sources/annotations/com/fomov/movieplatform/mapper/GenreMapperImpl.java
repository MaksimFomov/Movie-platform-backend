package com.fomov.movieplatform.mapper;

import com.fomov.movieplatform.dto.GenreDTO;
import com.fomov.movieplatform.model.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T10:21:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Azul Systems, Inc.)"
)
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDTO toGenreDTO(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDTO genreDTO = new GenreDTO();

        if ( genre.getId() != null ) {
            genreDTO.setId( genre.getId() );
        }
        genreDTO.setName( genre.getName() );

        return genreDTO;
    }

    @Override
    public Genre toGenre(GenreDTO genreDTO) {
        if ( genreDTO == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setId( genreDTO.getId() );
        genre.setName( genreDTO.getName() );

        return genre;
    }

    @Override
    public List<GenreDTO> toGenreDTOs(List<Genre> genres) {
        if ( genres == null ) {
            return null;
        }

        List<GenreDTO> list = new ArrayList<GenreDTO>( genres.size() );
        for ( Genre genre : genres ) {
            list.add( toGenreDTO( genre ) );
        }

        return list;
    }

    @Override
    public List<Genre> toGenres(List<GenreDTO> genreDTOs) {
        if ( genreDTOs == null ) {
            return null;
        }

        List<Genre> list = new ArrayList<Genre>( genreDTOs.size() );
        for ( GenreDTO genreDTO : genreDTOs ) {
            list.add( toGenre( genreDTO ) );
        }

        return list;
    }
}
